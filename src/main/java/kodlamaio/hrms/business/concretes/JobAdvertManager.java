package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı eklendi!");
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(), "İş ilanları getirildi!");
	}

	@Override
	public DataResult<List<JobAdvert>> getByApplicationDeadline(Date applicationDeadline) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByApplicationDeadline(applicationDeadline));
	}

	@Override
	public DataResult<List<JobAdvert>> getByStatus(boolean status) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByStatus(status),"İş ilanı aktif!");
	}

	@Override
	public DataResult<List<JobAdvert>> getByCity(City city) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByCity(city));
	}

}
