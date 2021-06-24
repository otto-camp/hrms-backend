package kodlamaio.hrms.entities.concretes.cv;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_language")
public class CvLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "language_name")
	private String language;
	
	@Column(name = "language_level")
	@Max(5)
	@Min(1)
	private int languageLevel;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	@JsonIgnore
	private Candidate candidate;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	@JsonIgnore
	private Cv cv;
}
