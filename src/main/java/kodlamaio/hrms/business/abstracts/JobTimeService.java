package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobTime;

public interface JobTimeService {

	Result add(JobTime jobTime);
	
	DataResult<List<JobTime>> getAll();
}
