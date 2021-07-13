package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.entities.dtos.CandidateRegisterDto;

public interface MernisService {
	public boolean checkIfRealPerson(CandidateRegisterDto candidateRegisterDto);
}
