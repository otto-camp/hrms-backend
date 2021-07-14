package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.ConfirmationCodeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adapters.MernisService;
import kodlamaio.hrms.core.confirmation.ConfirmationService;
import kodlamaio.hrms.core.email.EmailService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.ConfirmationCode;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.CandidateRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerRegisterDto;

@Service
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private EmployerService employerService;
	private MernisService mernisService;
	private UserService userService;
	private ConfirmationCodeService confirmationCodeService;
	private ConfirmationService confirmationService;
	private EmailService emailService;
	
	@Autowired
	public AuthManager(CandidateService candidateService, EmployerService employerService, MernisService mernisService,
			UserService userService, ConfirmationCodeService confirmationCodeService,
			ConfirmationService confirmationService, EmailService emailService) {
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.mernisService = mernisService;
		this.userService = userService;
		this.confirmationCodeService = confirmationCodeService;
		this.confirmationService = confirmationService;
		this.emailService = emailService;
	}

	@Override
	public Result registerEmployer(EmployerRegisterDto employerRegisterDto) {
		Employer employer = new Employer();
		if(!checkNullForEmployer(employerRegisterDto)) {
			return new ErrorResult("Bütün alanları doldurmak zorundasınız!");
		}
		if (!checkEmailAndDomain(employerRegisterDto.getEmail(), employerRegisterDto.getWebsite())) {
			return new ErrorResult("Yanlış email!");
		}
		if (!checkIfEmailExists(employerRegisterDto.getEmail())) {
			return new ErrorResult("Bu email zaten kayıtlı!");
		}
		if (!checkIfPasswordEqualsPasswordRep(employerRegisterDto.getPassword(), employerRegisterDto.getPasswordRep())) {
			return new ErrorResult("Şifreleriniz uyuşmuyor!");
		}
		employer.setCompanyName(employerRegisterDto.getCompanyName());
		employer.setEmail(employerRegisterDto.getEmail());
		employer.setPassword(employerRegisterDto.getPassword());
		employer.setPasswordRep(employerRegisterDto.getPasswordRep());
		employer.setPhoneNumber(employerRegisterDto.getPhoneNumber());
		//employer.setVerified(false);
		employer.setWebsite(employerRegisterDto.getWebsite());
		employerService.add(employer);
		String code = confirmationService.sendCode();
		ConfirmationCodeSender(code, employerRegisterDto.getId(), employerRegisterDto.getEmail());
		emailService.sendEmail("ismailyarar4@gmail.com", code, "Doğrulama");
		return new SuccessResult("Kayıt işlemi başarıyla tamamlandı!");
	}

	@Override
	public Result registerCandidate(CandidateRegisterDto candidateRegisterDto) {
		Candidate candidate = new Candidate();
		if (!checkNullForCandidate(candidateRegisterDto)) {
			return new ErrorResult("Bütün alanları doldurmak zorundasınız!");
		}
		if (mernisService.checkIfRealPerson(candidateRegisterDto) == false) {
			return new ErrorResult("Kimlik bilgileriniz hatalı!");
		}
		if (!checkIfEmailExists(candidateRegisterDto.getEmail())) {
			return new ErrorResult("Bu email zaten kayıtlı!");
		}
		if (!checkIfExistsIdentityNumber(candidateRegisterDto.getIdentityNumber())) {
			return new ErrorResult("Bu TCKN zaten kayıtlı!");
		}
		if(!checkIfPasswordEqualsPasswordRep(candidateRegisterDto.getPasswordRep(), candidateRegisterDto.getPassword())) {
			return new ErrorResult("Şifreleriniz uyuşmuyor!");
		}
		if(!isEmailValid(candidateRegisterDto.getEmail())) {
			return new ErrorResult("Emailiniz yanlış!");
		}
		candidate.setBirthDate(candidateRegisterDto.getBirthDate());
		candidate.setEmail(candidateRegisterDto.getEmail());
		candidate.setFirstName(candidateRegisterDto.getFirstName());
		candidate.setIdentityNumber(candidateRegisterDto.getIdentityNumber());
		candidate.setLastName(candidateRegisterDto.getLastName());
		candidate.setPassword(candidateRegisterDto.getPassword());
		candidate.setPasswordRep(candidateRegisterDto.getPasswordRep());
		candidateService.add(candidate);
		String code = confirmationService.sendCode();
		ConfirmationCodeSender(code, candidate.getId(), candidate.getEmail());
		emailService.sendEmail("ismailyarar4@gmail.com",code,"Doğrulama");
		return new SuccessResult("Kayıt işlemi başarıyla tamamlandı!");

	}

	private boolean checkNullForCandidate(CandidateRegisterDto candidateRegisterDto) {
		if (candidateRegisterDto.getFirstName() != null && candidateRegisterDto.getLastName() != null && candidateRegisterDto.getIdentityNumber() != null
				&& candidateRegisterDto.getBirthDate() != null && candidateRegisterDto.getEmail() != null && candidateRegisterDto.getPassword() != null
				&& candidateRegisterDto.getPasswordRep() != null) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkIfExistsIdentityNumber(String identityNumber) {
		if (this.candidateService.getByIdentityNumber(identityNumber).getData() == null) {
			return true;
		}
		return false;

	}

	private boolean checkIfEmailExists(String email) {
		if (this.userService.getByEmail(email).getData() == null) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkIfPasswordEqualsPasswordRep(String password, String passwordRep) {
		if (!password.equals(passwordRep)) {
			return false;
		}
		return true;
	}

	private boolean checkNullForEmployer(EmployerRegisterDto employerRegisterDto) {
		if (employerRegisterDto.getCompanyName() != null && employerRegisterDto.getEmail() != null && employerRegisterDto.getPassword() != null
				&& employerRegisterDto.getPhoneNumber() != null && employerRegisterDto.getWebsite() != null) {
			return true;
		}
		return false;
	}

	private boolean checkEmailAndDomain(String email, String website) {
		String[] emailArr = email.split("@", 2);
		String domain = website.substring(4, website.length());
		if (emailArr[1].equals(domain)) {
			return true;
		}
		return false;

	}
	private boolean isEmailValid(String email) {
		String emailPattern = "^[a-zA-Z0-9_!#$%&â€™*+/=?`{|}~^.-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";

		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		return pattern.matcher(email).find();

	}
	
	private void ConfirmationCodeSender(String code, int id, String email) {
		ConfirmationCode confirmationCode = new ConfirmationCode(id, code, false , LocalDate.now());
		this.confirmationCodeService.add(confirmationCode);
	}
}
