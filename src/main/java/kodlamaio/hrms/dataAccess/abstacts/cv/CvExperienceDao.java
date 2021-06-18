package kodlamaio.hrms.dataAccess.abstacts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.CvExperience;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer>{

	CvExperience getById(int id);
	List<CvExperience> getAllByCandidateId(int id);
	List<CvExperience> getAllByCandidate_IdOrderByEndDateDesc(int id);
}
