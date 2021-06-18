package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.CvExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.cv.CvExperienceDao;
import kodlamaio.hrms.entities.concretes.cv.CvExperience;

@Service
public class CvExperienceManager implements CvExperienceService{

	private CvExperienceDao cvExperienceDao;
	
	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao) {
		super();
		this.cvExperienceDao = cvExperienceDao;
	}

	@Override
	public Result add(CvExperience cvExperience) {
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("İş tecrübeniz eklendi!");
	}

	@Override
	public Result update(CvExperience cvExperience) {
		this.cvExperienceDao.save(cvExperience);
		return new SuccessResult("İş tecrübeniz güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.cvExperienceDao.deleteById(id);
		return new SuccessResult("İş tecrübeniz silindi!");
	}

	@Override
	public DataResult<CvExperience> getById(int id) {
		return new SuccessDataResult<CvExperience>(this.cvExperienceDao.getById(id));
	}

	@Override
	public DataResult<List<CvExperience>> getAll() {
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.findAll());
	}

	@Override
	public DataResult<List<CvExperience>> getByCandidateId(int id) {
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByCandidateId(id));
	}

	@Override
	public DataResult<List<CvExperience>> getAllByCandidateIdOrderByEndDateDesc(int id) {
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByCandidate_IdOrderByEndDateDesc(id));
	}

}
