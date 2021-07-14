package kodlamaio.hrms.dataAccess.abstacts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	boolean existsByEmail(String email);
	Employer getByEmail(String email);
}
