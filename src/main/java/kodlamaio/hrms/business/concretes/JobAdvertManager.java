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
import kodlamaio.hrms.dataAccess.abstacts.CityDao;
import kodlamaio.hrms.dataAccess.abstacts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstacts.JobAdvertDao;
import kodlamaio.hrms.dataAccess.abstacts.JobTimeDao;
import kodlamaio.hrms.dataAccess.abstacts.JobTitleDao;
import kodlamaio.hrms.dataAccess.abstacts.JobTypeDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.JobAdvertAddDto;

@Service
public class JobAdvertManager implements JobAdvertService{
	
	private JobAdvertDao jobAdvertDao;
	private EmployerDao employerDao;
	private CityDao cityDao;
	private JobTimeDao jobTimeDao;
	private JobTypeDao jobTypeDao;
	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao, EmployerDao employerDao, CityDao cityDao, JobTimeDao jobTimeDao,
			JobTypeDao jobTypeDao, JobTitleDao jobTitleDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
		this.employerDao = employerDao;
		this.cityDao = cityDao;
		this.jobTimeDao = jobTimeDao;
		this.jobTypeDao = jobTypeDao;
		this.jobTitleDao = jobTitleDao;
	}
	
	@Override
	public Result add(JobAdvertAddDto jobAdvertDto) {
		JobAdvert jobAdvert = new JobAdvert();
		jobAdvert.setApplicationDeadline(jobAdvertDto.getDeadLine());
		jobAdvert.setCity(this.cityDao.getById(jobAdvertDto.getCityId()));
		jobAdvert.setDescription(jobAdvertDto.getDescription());
		jobAdvert.setEmployer(this.employerDao.getById(jobAdvertDto.getEmployerId()));
		jobAdvert.setJobTitle(this.jobTitleDao.getById(jobAdvertDto.getJobTitleId()));
		jobAdvert.setJobTime(this.jobTimeDao.getById(jobAdvertDto.getJobTimesId()));
		jobAdvert.setJobType(this.jobTypeDao.getById(jobAdvertDto.getJobTypeId()));
		jobAdvert.setMaxSalaries(jobAdvertDto.getMaxSalaries());
		jobAdvert.setMinSalaries(jobAdvertDto.getMinSalaries());
		jobAdvert.setVacantPositionNumber(jobAdvertDto.getVacantPositionNumber());
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
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByStatus(status));
	}

	@Override
	public DataResult<List<JobAdvert>> getByCity(City city) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByCity(city));
	}

	@Override
	public Result updateJobAdvert(boolean isVerified, int id) {
		this.jobAdvertDao.changeverify(isVerified, id);
		return new SuccessResult("İlan durumu değiştirildi!");
	}

	@Override
	public Result changestatus(boolean status, int id) {
		this.jobAdvertDao.changestatus(status, id);
		return new SuccessResult("İlan aktiflik durumu değiştirildi!");
	}

}
