package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.CvService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstacts.cv.CvDao;
import kodlamaio.hrms.dataAccess.abstacts.cv.CvLanguageDao;
import kodlamaio.hrms.dataAccess.abstacts.cv.CvPhotoDao;
import kodlamaio.hrms.entities.concretes.cv.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService {
	
	private CvDao cvDao;
	private CandidateDao candidateDao;
	private CvPhotoDao cvPhotoDao;
	private CvLanguageDao cvLanguageDao;
	
	@Autowired
	public CvManager(CvDao cvDao, CandidateDao candidateDao, CvPhotoDao cvPhotoDao, CvLanguageDao cvLanguageDao) {
		super();
		this.cvDao = cvDao;
		this.candidateDao = candidateDao;
		this.cvPhotoDao = cvPhotoDao;
		this.cvLanguageDao = cvLanguageDao;
	}

	@Override
	public Result add(CvDto cvDto) {
		Cv cv = new Cv();
		cv.setCandidate(this.candidateDao.getById(cvDto.getCandidateId()));
		cv.setCoverLetter(cvDto.getCoverLetter());
		cv.setGithubLink(cvDto.getGithubLink());
		cv.setLinkedinLink(cvDto.getLinkedinLink());
		cv.setProgrammingLanguage(cvDto.getProgrammingLanguage());
		cv.setSkills(cvDto.getSkills());
		cv.setCvLanguage(this.cvLanguageDao.getById(cvDto.getLanguageId()));
		cv.setCvPhoto(this.cvPhotoDao.getById(cvDto.getPhotoId()));
		this.cvDao.save(cv);
		return new SuccessResult("Cv kaydedildi!");
	}

	@Override
	public Result update(Cv cv) {
		Cv cvUp = cvDao.getById(cv.getId());
		cvUp = cv;
		cvDao.save(cvUp);
		return new SuccessResult("Cv güncellendi!");
	}

	@Override
	public Result delete(Cv cv) {
		this.cvDao.delete(cv);
		return new SuccessResult("Cv silindi!");
	}

	@Override
	public DataResult<Cv> getById(int id) {
		return new SuccessDataResult<Cv>(this.cvDao.getById(id));
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(),"Cvler getirildi!");
	}

	@Override
	public DataResult<Cv> getByCandidateId(int id) {
		return new SuccessDataResult<Cv>(this.cvDao.getByCandidateId(id));
	}

}
