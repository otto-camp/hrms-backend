package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.CvEducationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.cv.CvEducationDao;
import kodlamaio.hrms.entities.concretes.cv.CvEducation;

@Service
public class CvEducationManager implements CvEducationService{

	private CvEducationDao cvEducationDao;

	@Autowired
	public CvEducationManager(CvEducationDao cvEducationDao) {
		super();
		this.cvEducationDao = cvEducationDao;
	}

	@Override
	public Result add(CvEducation cvEducation) {
		this.cvEducationDao.save(cvEducation);
		return new SuccessResult("Eğitim bilgileriniz eklendi!");
	}

	@Override
	public Result update(CvEducation cvEducation) {
		this.cvEducationDao.save(cvEducation);
		return new SuccessResult("Eğitim bilgileriniz güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.cvEducationDao.deleteById(id);
		return new SuccessResult("Eğitim bilgileriniz silindi!");
	}

	@Override
	public DataResult<CvEducation> getById(int id) {
		return new SuccessDataResult<CvEducation>(this.cvEducationDao.getById(id));
	}

	@Override
	public DataResult<List<CvEducation>> getAll() {
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.findAll());
	}

	@Override
	public DataResult<List<CvEducation>> getByCandidateId(int id) {
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.getAllByCandidateId(id));
	}

	@Override
	public DataResult<List<CvEducation>> getByCandidateIdOrderByGraduationDateDesc(int id) {
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.getAllByCandidateIdOrderByGraduationDateDesc(id));
	}
}
