package kodlamaio.hrms.dataAccess.abstacts.cv;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.CvPhoto;

public interface CvPhotoDao extends JpaRepository<CvPhoto, Integer>{
	CvPhoto getById(int id);
	CvPhoto getByCandidateId(int id);
}
