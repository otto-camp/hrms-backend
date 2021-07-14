package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstacts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.UserLoginDto;
@Service
public class UserManager implements UserService{

	
	private UserDao userDao;
	private EmployerService employerService;
	private EmployeeService employeeService;
	private CandidateService candidateService;
	
	@Autowired
	public UserManager(UserDao userDao, EmployerService employerService, EmployeeService employeeService,
			CandidateService candidateService) {
		super();
		this.userDao = userDao;
		this.employerService = employerService;
		this.employeeService = employeeService;
		this.candidateService = candidateService;
	}

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Kullanıcılar başarıyla getirildi!");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.getByEmail(email));
	}

	@Override
	public DataResult<User> getById(int id) {
		return new SuccessDataResult<User>(this.userDao.getById(id));
	}

	@Override
	public DataResult<?> login(UserLoginDto userDto) {
		DataResult<User> findUser = getByEmailAndPassword(userDto.getEmail(), userDto.getPassword());
		if(!findUser.isSuccess()) {
			return new ErrorDataResult<>("Kullanıcı bulunamadı!");
		}
		DataResult<Employer> findEmployer = employerService.getByEmail(userDto.getEmail());
		if(findEmployer.getData() != null) {
			return new SuccessDataResult<>(findEmployer.getData(),"Giriş başarılı!");
		}
		DataResult<Employee> findEmployee = employeeService.getByEmail(userDto.getEmail());
		if(findEmployee.getData() != null) {
			return new SuccessDataResult<>(findEmployee.getData(),"Giriş başarılı!");
		}
		DataResult<Candidate> findCandidate = candidateService.getByEmail(userDto.getEmail());
		if(findCandidate.getData() != null) {
			return new SuccessDataResult<>(findCandidate.getData(),"Giriş başarılı!");
		}
		return new ErrorDataResult<>("Giriş sağlanamadı!");
	}

	@Override
	public DataResult<User> getByEmailAndPassword(String email, String password) {
		User user = this.userDao.getByEmailAndPassword(email, password);
		if (user == null) {
			return new ErrorDataResult<User>("Kullanıcı bulunamadı!");
		} else {
			return new SuccessDataResult<User>("Kullanıcı bulundu!");
		}
	}
}
