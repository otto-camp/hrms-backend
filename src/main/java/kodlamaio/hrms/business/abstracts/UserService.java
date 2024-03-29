package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.UserLoginDto;

public interface UserService {
	
	//Result add(User user);
	
	DataResult<List<User>> getAll();
	
	DataResult<User> getById(int id);
	
	DataResult<User> getByEmail(String email);
	
	DataResult<User> getByEmailAndPassword(String email, String password);
	
	DataResult<?> login(UserLoginDto userDto);
}
