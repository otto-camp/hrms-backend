package kodlamaio.hrms.core.adapters;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisService {
	public boolean checkIfRealPerson(Candidate candidate);
}
