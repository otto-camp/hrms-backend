package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	private int id;
	private int candidateId;
	private String githubLink;
	private String linkedinLink;
	private String skills;
	private String coverLetter;
	private String programmingLanguage;
	private int languageId;
	private int photoId;
	
}
