package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTimeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.JobTimeDao;
import kodlamaio.hrms.entities.concretes.JobTime;
@Service
public class JobTimeManager implements JobTimeService{

	private JobTimeDao jobTimeDao;
	@Autowired
	public JobTimeManager(JobTimeDao jobTimeDao) {
		super();
		this.jobTimeDao = jobTimeDao;
	}
	@Override
	public Result add(JobTime jobTime) {
		this.jobTimeDao.save(jobTime);
		return new SuccessResult();
	}
	@Override
	public DataResult<List<JobTime>> getAll() {
		return new SuccessDataResult<List<JobTime>>(this.jobTimeDao.findAll());
	} 
}
