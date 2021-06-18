package kodlamaio.hrms.business.abstracts.cv;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.cv.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

public interface CvService {
	
	Result add(CvDto cvDto, int candidateId);
	Result update(CvDto cvDto, int candidateId);
	Result delete(int candidateId);
	
	DataResult<List<Cv>> getAll();
}
