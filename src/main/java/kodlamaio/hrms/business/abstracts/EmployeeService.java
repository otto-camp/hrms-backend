package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Employee;
public interface EmployeeService {
	Result add(Employee employee);
	DataResult<List<Employee>> getAll();
	DataResult<Employee> getByEmail(String email);

}
