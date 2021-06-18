package kodlamaio.hrms.dataAccess.abstacts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.CvLanguage;

public interface CvLanguageDao extends JpaRepository<CvLanguage, Integer>{
	
	CvLanguage getById(int id);
	List<CvLanguage> getAllByCandidateId(int id);
}
