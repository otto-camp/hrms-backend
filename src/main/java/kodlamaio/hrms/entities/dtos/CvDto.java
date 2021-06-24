package kodlamaio.hrms.entities.dtos;


import java.util.List;

import kodlamaio.hrms.entities.concretes.cv.Cv;
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

	private int candidateId;
	private String githubLink;
	private String linkedinLink;
	private String skills;
	private String coverLetter;
	private String programmingLanguage;
	
	Cv cv;
	CvEducation cvEducation;
	CvExperience cvExperience;
	CvLanguage language;
	CvPhoto cvPhoto;
}
