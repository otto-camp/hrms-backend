package kodlamaio.hrms.dataAccess.abstacts.cv;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Integer>{
	Faculty getById(int id);
}
