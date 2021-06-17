package kodlamaio.hrms.entities.dtos;

import lombok.Data;

@Data
public class EmployerRegisterDto {
	private String email;
	private String password;
	private String passwordRep;
	private String website;
	private String phoneNumber;
	private String companyName;
}	
