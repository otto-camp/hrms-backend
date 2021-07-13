package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import kodlamaio.hrms.entities.concretes.cv.Cv;
import kodlamaio.hrms.entities.concretes.cv.CvEducation;
import kodlamaio.hrms.entities.concretes.cv.CvExperience;
import kodlamaio.hrms.entities.concretes.cv.CvLanguage;
import kodlamaio.hrms.entities.concretes.cv.CvPhoto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Candidate extends User {

	@Column(name = "user_id")
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "identity_number")
	private String identityNumber;

	@Column(name = "birth_date")
	private LocalDate birthDate;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	@JsonManagedReference
	private List<CvEducation> cvEducations;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	@JsonManagedReference
	private List<CvLanguage> cvLanguages;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	@JsonManagedReference
	private List<CvExperience> cvExperiences;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	@JsonManagedReference
	private List<CvPhoto> cvPhotos;

	@OneToMany(mappedBy = "candidate")
	@JsonIgnore
	@JsonManagedReference
	private List<Cv> cvs;
}
