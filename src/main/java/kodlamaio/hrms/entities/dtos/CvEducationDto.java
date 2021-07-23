package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvEducationDto {
	private int id;
	private int candidateId;
	private LocalDate startDate;
	private LocalDate graduationDate;
	private int universityId;
	private int facultyId;
	private int sectionId;
}
