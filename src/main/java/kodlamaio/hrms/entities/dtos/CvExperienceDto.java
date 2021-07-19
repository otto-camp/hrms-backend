package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvExperienceDto {

	private int id;
	private String companyName;
	private String positionName;
	private LocalDate startDate;
	private LocalDate endDate;
	private int candidateId;
}
