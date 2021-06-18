package kodlamaio.hrms.business.abstracts.cv;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.cv.CvPhoto;

public interface CvPhotoService {
	Result add(CvPhoto cvPhoto, MultipartFile file);
	Result update(CvPhoto cvPhoto);
	Result delete(int id);
	
	DataResult<CvPhoto> getById(int id);
	DataResult<List<CvPhoto>> getAll();
	DataResult<CvPhoto> getByCandidateId(int id);
}
