package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.cv.CvEducation;
import kodlamaio.hrms.entities.concretes.cv.CvExperience;
import kodlamaio.hrms.entities.concretes.cv.CvLanguage;
import kodlamaio.hrms.entities.concretes.cv.CvPhoto;
import lombok.Data;

@Data
public class CvDto {

	private Candidate candidate;
	private CvEducation cvEducations;
	private CvExperience cvExperiences;
	private CvLanguage cvLanguages;
	private CvPhoto cvPhotos;
}
