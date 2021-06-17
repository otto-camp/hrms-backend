package kodlamaio.hrms.business.abstracts;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	
	Result add(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvert>> getAll();
	
	DataResult<List<JobAdvert>> getByApplicationDeadline(Date applicationDeadline);
	
	DataResult<List<JobAdvert>> getByStatus(boolean status);
	
	DataResult<List<JobAdvert>> getByCity(City city);
}
