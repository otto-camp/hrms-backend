package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateRegisterDto {

	private int id;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String identityNumber;
	private String email;
	private String password;
	private String passwordRep;
	
}
