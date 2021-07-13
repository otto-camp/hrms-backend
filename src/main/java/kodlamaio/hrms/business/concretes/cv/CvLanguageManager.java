package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.CvLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.cv.CvLanguageDao;
import kodlamaio.hrms.entities.concretes.cv.CvLanguage;

@Service
public class CvLanguageManager implements CvLanguageService{

	private CvLanguageDao cvLanguageDao;
	
	@Autowired
	public CvLanguageManager(CvLanguageDao cvLanguageDao) {
		super();
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public Result add(CvLanguage cvLanguage) {
		this.cvLanguageDao.save(cvLanguage);
		return new SuccessResult("Yabancı dil eklendi!");
	}

	@Override
	public Result update(CvLanguage cvLanguage) {
		CvLanguage language = cvLanguageDao.getById(cvLanguage.getId());
		language = cvLanguage;
		cvLanguageDao.save(language);
		return new SuccessResult("Yabancı dil güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.cvLanguageDao.deleteById(id);
		return new SuccessResult("Yabancı dil silindi!");
	}

	@Override
	public DataResult<CvLanguage> getById(int id) {
		return new SuccessDataResult<CvLanguage>(this.cvLanguageDao.getById(id));
	}

	@Override
	public DataResult<List<CvLanguage>> getAll() {
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.findAll());
	}

	@Override
	public DataResult<List<CvLanguage>> getByCandidateId(int id) {
		return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.getAllByCandidateId(id));
	}

}
