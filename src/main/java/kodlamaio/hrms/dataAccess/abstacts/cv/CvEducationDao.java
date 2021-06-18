package kodlamaio.hrms.dataAccess.abstacts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.CvEducation;

public interface CvEducationDao extends JpaRepository<CvEducation, Integer>{

	CvEducation getById(int id);
	List<CvEducation> getAllByCandidateId(int id);
	List<CvEducation> getAllByCandidateIdOrderByGraduationDateDesc(int id);
}
