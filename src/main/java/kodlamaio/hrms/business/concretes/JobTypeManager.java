package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTypeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.JobTypeDao;
import kodlamaio.hrms.entities.concretes.JobType;
@Service
public class JobTypeManager implements JobTypeService{

	private JobTypeDao jobTypeDao;
	@Autowired
	public JobTypeManager(JobTypeDao jobTypeDao) {
		super();
		this.jobTypeDao = jobTypeDao;
	}
	@Override
	public Result add(JobType jobType) {
		this.jobTypeDao.save(jobType);
		return new SuccessResult();
	}
	@Override
	public DataResult<List<JobType>> getAll() {
		return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll());
	}
	
}
