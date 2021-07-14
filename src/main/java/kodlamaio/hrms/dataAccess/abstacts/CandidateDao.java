package kodlamaio.hrms.dataAccess.abstacts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	Candidate getByIdentityNumber(String identityNumber);
	Candidate getById(int id);
	Candidate getByEmail(String email);
}
