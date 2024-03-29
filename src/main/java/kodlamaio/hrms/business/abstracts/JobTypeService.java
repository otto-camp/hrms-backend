package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobType;

public interface JobTypeService {

	Result add(JobType jobType);
	
	DataResult<List<JobType>> getAll();
}
