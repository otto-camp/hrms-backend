package kodlamaio.hrms.dataAccess.abstacts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobType;

public interface JobTypeDao extends JpaRepository<JobType, Integer>{

	JobType getById(int id);
}
