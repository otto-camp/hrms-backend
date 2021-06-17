package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.adapters.MernisService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstacts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class AuthManager implements AuthService {

	private CandidateService candidateService;
	private EmployerService employerService;
	private MernisService mernisService;
	private UserService userService;

	@Autowired
	public AuthManager(CandidateService candidateService, EmployerService employerService, MernisService mernisService,
			 UserService userService) {
		super();
		this.candidateService = candidateService;
		this.employerService = employerService;
		this.mernisService = mernisService;
		this.userService = userService;
	}

	@Override
	public Result registerEmployer(Employer employer, String password) {
		if(!checkNullForEmployer(employer)) {
			return new ErrorResult("Bütün alanları doldurmak zorundasınız!");
		}
		if (!checkEmailAndDomain(employer.getEmail(), employer.getWebsite())) {
			return new ErrorResult("Yanlış email!");
		}
		if (!checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult("Bu email zaten kayıtlı!");
		}
		if (!checkIfPasswordEqualsPasswordRep(employer.getPassword(), employer.getPasswordRep())) {
			return new ErrorResult("Şifreleriniz uyuşmuyor!");
		}
		employerService.add(employer);
		return new SuccessResult("Kayıt işlemi başarıyla tamamlandı!");
	}

	@Override
	public Result registerCandidate(Candidate candidate, String passwordRep) {
		if (!checkNullForCandidate(candidate, passwordRep)) {
			return new ErrorResult("Bütün alanları doldurmak zorundasınız!");
		}
		if (mernisService.checkIfRealPerson(candidate) == false) {
			return new ErrorResult("Kimlik bilgileriniz hatalı!");
		}
		if (!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("Bu email zaten kayıtlı!");
		}
		if (!checkIfExistsIdentityNumber(candidate.getIdentityNumber())) {
			return new ErrorResult("Bu TCKN zaten kayıtlı!");
		}
		if(!checkIfPasswordEqualsPasswordRep(passwordRep, candidate.getPassword())) {
			return new ErrorResult("Şifreleriniz uyuşmuyor!");
		}
		candidateService.add(candidate);
		return new SuccessResult("Kayıt işlemi başarıyla tamamlandı!");

	}

	private boolean checkNullForCandidate(Candidate candidate, String passwordRep) {
		if (candidate.getFirstName() != null && candidate.getLastName() != null && candidate.getIdentityNumber() != null
				&& candidate.getBirthDate() != null && candidate.getEmail() != null && candidate.getPassword() != null
				&& passwordRep != null) {
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

	private boolean checkNullForEmployer(Employer employer) {
		if (employer.getCompanyName() != null && employer.getEmail() != null && employer.getPassword() != null
				&& employer.getPhoneNumber() != null && employer.getWebsite() != null) {
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
}
