package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerRegisterDto {

	private int id;
	private String companyName;
	private String website;
	private String email;
	private String phoneNumber;
	private String password;
	private String passwordRep;
}
