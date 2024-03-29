package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employee extends User{
	
	@Column(name="user_id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@OneToMany(mappedBy = "employee")
	@JsonIgnore
	private List<JobAdvert> jobAdverts;
	
	@OneToMany(mappedBy = "employee")
	private List<Employer> employers;
}
