package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.CvEducationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstacts.cv.CvEducationDao;
import kodlamaio.hrms.dataAccess.abstacts.cv.FacultyDao;
import kodlamaio.hrms.dataAccess.abstacts.cv.SectionDao;
import kodlamaio.hrms.dataAccess.abstacts.cv.UniversityDao;
import kodlamaio.hrms.entities.concretes.cv.CvEducation;
import kodlamaio.hrms.entities.dtos.CvEducationDto;

@Service
public class CvEducationManager implements CvEducationService {
	
	private CvEducationDao cvEducationDao;
	private CandidateDao candidateDao;
	private UniversityDao universityDao;
	private FacultyDao facultyDao;
	private SectionDao sectionDao;
	
	@Autowired
	public CvEducationManager(CvEducationDao cvEducationDao, CandidateDao candidateDao, UniversityDao universityDao,FacultyDao facultyDao,SectionDao sectionDao) {
		super();
		this.cvEducationDao = cvEducationDao;
		this.candidateDao = candidateDao;
		this.universityDao = universityDao;
		this.facultyDao = facultyDao;
		this.sectionDao = sectionDao;
	}

	@Override
	public Result add(CvEducationDto cvEducationDto) {
		CvEducation cvEducation = new CvEducation();
		cvEducation.setCandidate(this.candidateDao.getById(cvEducationDto.getCandidateId()));
		cvEducation.setStartDate(cvEducationDto.getStartDate());
		cvEducation.setGraduationDate(cvEducationDto.getGraduationDate());
		cvEducation.setUniversity(this.universityDao.getById(cvEducationDto.getUniversityId()));
		cvEducation.setFaculty(this.facultyDao.getById(cvEducationDto.getFacultyId()));
		cvEducation.setSection(this.sectionDao.getById(cvEducationDto.getSectionId()));
		this.cvEducationDao.save(cvEducation);
		return new SuccessResult("Eğitim bilgileriniz eklendi!");

	}

	@Override
	public Result update(CvEducation cvEducation) {
		CvEducation education = cvEducationDao.getById(cvEducation.getId());
		education = cvEducation;
		cvEducationDao.save(education);
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
		return new SuccessDataResult<List<CvEducation>>(
				this.cvEducationDao.getAllByCandidateIdOrderByGraduationDateDesc(id));
	}
}
