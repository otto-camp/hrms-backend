package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_adverts")
public class JobAdvert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Column(name="max_salaries")
	private double maxSalaries;
	
	@Column(name="min_salaries")
	private double minSalaries;
	
	@Column(name="vacant_position_number")
	private String vacantPositionNumber;
	
	@Column(name="application_start_date")
	private Date applicationStartDate;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline = LocalDate.now();
	
	@Column(name="status")
	private boolean status;
	
	//@ManyToOne()
	//@JoinColumn(name="employer_id")
	//private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "city")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name="job_title", referencedColumnName = "id")
	private JobTitle jobTitle;
}
