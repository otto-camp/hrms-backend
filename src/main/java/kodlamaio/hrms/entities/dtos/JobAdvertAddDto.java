package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertAddDto {

	private int jobAdvertId;
	private int employerId;
	private String description;
	private double minSalaries;
	private double maxSalaries;
	private String vacantPositionNumber;
	private LocalDate deadLine;
	private boolean status;
	private int cityId;
	private int jobTitleId;
	private int jobTypeId;
	private int jobTimesId;
}
