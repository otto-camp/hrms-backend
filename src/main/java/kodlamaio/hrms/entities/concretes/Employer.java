package kodlamaio.hrms.entities.concretes;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="employers")
@Entity
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employer extends User{
	
	@Column(name="user_id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	//@Column(name = "is_verified")
	//private boolean isVerified = false;
	
	@OneToMany(mappedBy = "employer")
	@JsonIgnore
	private transient List<JobAdvert> jobAdverts;
	
	@ManyToOne()
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
}
