package kodlamaio.hrms.business.abstracts.cv;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.cv.CvExperience;

public interface CvExperienceService {
	Result add(CvExperience cvExperience);

	Result update(CvExperience cvExperience);

	Result delete(int id);

	DataResult<CvExperience> getById(int id);

	DataResult<List<CvExperience>> getAll();

	DataResult<List<CvExperience>> getByCandidateId(int id);

	DataResult<List<CvExperience>> getAllByCandidateIdOrderByEndDateDesc(int id);
}
