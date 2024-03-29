package kodlamaio.hrms.dataAccess.abstacts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobTime;

public interface JobTimeDao extends JpaRepository<JobTime, Integer>{

	JobTime getById(int id);
}
