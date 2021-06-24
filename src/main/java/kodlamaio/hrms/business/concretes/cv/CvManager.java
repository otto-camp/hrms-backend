package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.cv.CvEducationService;
import kodlamaio.hrms.business.abstracts.cv.CvExperienceService;
import kodlamaio.hrms.business.abstracts.cv.CvLanguageService;
import kodlamaio.hrms.business.abstracts.cv.CvPhotoService;
import kodlamaio.hrms.business.abstracts.cv.CvService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.cv.CvDao;
import kodlamaio.hrms.entities.concretes.cv.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

@Service
public class CvManager implements CvService {

	private CvDao cvDao;
	private CandidateService candidateService;
	private CvEducationService cvEducationService;
	private CvExperienceService cvExperienceService;
	private CvLanguageService cvLanguageService;
	private CvPhotoService cvPhotoService;

	@Autowired
	public CvManager(CvDao cvDao, CandidateService candidateService, CvEducationService cvEducationService,
			CvExperienceService cvExperienceService, CvLanguageService cvLanguageService,
			CvPhotoService cvPhotoService) {
		super();
		this.cvDao = cvDao;
		this.candidateService = candidateService;
		this.cvEducationService = cvEducationService;
		this.cvExperienceService = cvExperienceService;
		this.cvLanguageService = cvLanguageService;
		this.cvPhotoService = cvPhotoService;
	}

	@Override
	public Result add(CvDto cvDto) {
		this.cvEducationService.add(cvDto.getCvEducation());
		this.cvExperienceService.add(cvDto.getCvExperience());
		this.cvLanguageService.add(cvDto.getLanguage());
		this.cvPhotoService.add(cvDto.getCvPhoto(), null);
		this.cvDao.save(cvDto.getCv());
		return new SuccessResult("Cv güncellendi!");
	}

	@Override
	public Result update(CvDto cvDto) {
		this.cvEducationService.add(cvDto.getCvEducation());
		this.cvExperienceService.add(cvDto.getCvExperience());
		this.cvLanguageService.add(cvDto.getLanguage());
		this.cvPhotoService.add(cvDto.getCvPhoto(), null);
		this.cvDao.save(cvDto.getCv());
		return new SuccessResult("Cv güncellendi!");
	}

	@Override
	public Result delete(Cv cv) {
		this.delete(cv);
		return new SuccessResult("Cv silindi!");
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
	}

	@Override
	public DataResult<Cv> getByCandidateId(int candidateId) {
		return new SuccessDataResult<Cv>(cvDao.getByCandidateId(candidateId));
	}

	@Override
	public DataResult<CvDto> getCvByCandidateId(int candidateId) {
		return null;
	}

}
