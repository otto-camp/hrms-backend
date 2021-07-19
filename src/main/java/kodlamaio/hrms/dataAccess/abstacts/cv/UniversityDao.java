package kodlamaio.hrms.dataAccess.abstacts.cv;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.University;

public interface UniversityDao extends JpaRepository<University, Integer>{
	University getById(int id);
}
