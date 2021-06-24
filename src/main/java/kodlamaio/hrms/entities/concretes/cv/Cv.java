package kodlamaio.hrms.entities.concretes.cv;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cv")
public class Cv {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "github_link")
	private String githubLink;

	@Column(name = "linkedin_link")
	private String linkedinLink;

	@Column(name = "skills")
	private String skills;

	@Column(name = "cover_letter")
	private String coverLetter;

	@Column(name = "programming_language")
	private String programmingLanguage;

	@ManyToOne
	@JoinColumn(name = "candidate_id")
	@JsonIgnore
	private Candidate candidate;

	@OneToMany(mappedBy = "cv")
	private List<CvEducation> cvEducations;

	@OneToMany(mappedBy = "cv")
	private List<CvExperience> cvExperiences;

	@OneToMany(mappedBy = "cv")
	private List<CvLanguage> cvLanguages;

	@OneToMany(mappedBy = "cv")
	private List<CvPhoto> cvPhotos;

	public Cv(Candidate candidate, String a, String b, String c, String d, String e) {
	}
}
