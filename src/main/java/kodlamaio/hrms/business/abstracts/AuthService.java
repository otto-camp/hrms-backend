package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.dtos.CandidateRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerRegisterDto;

public interface AuthService {
	Result registerEmployer(EmployerRegisterDto employerRegisterDto);
	
	Result registerCandidate(CandidateRegisterDto candidateRegisterDto);
	
}
