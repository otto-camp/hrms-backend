package kodlamaio.hrms.dataAccess.abstacts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.Cv;

public interface CvDao extends JpaRepository<Cv, Integer>{

	Cv getById(int id);
	List<Cv> getByCandidateId(int id);
}
