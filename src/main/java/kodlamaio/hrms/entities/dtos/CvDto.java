package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.cv.CvEducation;
import kodlamaio.hrms.entities.concretes.cv.CvExperience;
import kodlamaio.hrms.entities.concretes.cv.CvLanguage;
import kodlamaio.hrms.entities.concretes.cv.CvPhoto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {

	private int id;
	private Candidate candidate;
	private CvEducation cvEducations;
	private CvExperience cvExperiences;
	private CvLanguage cvLanguages;
	private CvPhoto cvPhotos;
}
