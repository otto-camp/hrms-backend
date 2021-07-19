package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.hrms.entities.concretes.cv.University;
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
	private List<University> universities;
}
