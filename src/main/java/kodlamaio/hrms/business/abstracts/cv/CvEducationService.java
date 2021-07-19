package kodlamaio.hrms.business.abstracts.cv;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.cv.CvEducation;
import kodlamaio.hrms.entities.dtos.CvEducationDto;

public interface CvEducationService {
	Result add(CvEducationDto cvEducationDto);

	Result update(CvEducation cvEducation);

	Result delete(int id);

	DataResult<CvEducation> getById(int id);

	DataResult<List<CvEducation>> getAll();

	DataResult<List<CvEducation>> getByCandidateId(int id);

	DataResult<List<CvEducation>> getByCandidateIdOrderByGraduationDateDesc(int id);
}
