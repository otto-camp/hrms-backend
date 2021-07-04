package kodlamaio.hrms.business.abstracts.cv;


import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.cv.Cv;

public interface CvService {
	
	Result add(Cv cv);
	Result update (Cv cv);
	Result delete(Cv cv);
	
	DataResult<Cv> getById(int id);
	DataResult<List<Cv>> getAll();
	DataResult<Cv> getByCandidateId(int id);

}
