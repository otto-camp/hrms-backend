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
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.cv.Cv;
import kodlamaio.hrms.entities.concretes.cv.CvEducation;
import kodlamaio.hrms.entities.concretes.cv.CvExperience;
import kodlamaio.hrms.entities.concretes.cv.CvLanguage;
import kodlamaio.hrms.entities.concretes.cv.CvPhoto;
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
	public Result add(CvDto cvDto, int candidateId) {
		Candidate candidate = candidateService.getById(candidateId).getData();
		cvDto.setCandidate(candidate);
		
		CvEducation cvEducation = cvEducationService.getById(candidateId).getData();
		cvDto.setCvEducations(cvEducation);
		
		CvExperience cvExperience = cvExperienceService.getById(candidateId).getData();
		cvDto.setCvExperiences(cvExperience);
		
		
		CvLanguage cvLanguage = cvLanguageService.getById(candidateId).getData();
		cvDto.setCvLanguages(cvLanguage);
		
		CvPhoto cvPhoto = cvPhotoService.getById(candidateId).getData();
		cvDto.setCvPhotos(cvPhoto);
		
	}

	@Override
	public Result update(CvDto cvDto, int candidateId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int candidateId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
	}

}
