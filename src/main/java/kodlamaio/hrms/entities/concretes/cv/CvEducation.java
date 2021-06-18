package kodlamaio.hrms.entities.concretes.cv;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;

import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_educations")
public class CvEducation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "start_date")
	@PastOrPresent
	private LocalDate startDate;
	
	@Column(name = "graduation_date")
	@PastOrPresent
	private LocalDate graduationDate;
	
	@OneToOne(mappedBy = "university_id")
	private transient University university;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

}
