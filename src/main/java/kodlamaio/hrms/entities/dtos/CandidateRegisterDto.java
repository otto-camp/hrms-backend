package kodlamaio.hrms.entities.dtos;

import lombok.Data;

@Data
public class CandidateRegisterDto {
	private String email;
	private String password;
	private String passwordRep;
	private String firstName;
	private String lastName;
	private String identityNumber;
	private String birthDate;
	
}
