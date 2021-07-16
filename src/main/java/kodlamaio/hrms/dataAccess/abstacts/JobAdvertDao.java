package kodlamaio.hrms.dataAccess.abstacts;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	JobAdvert getById(int id);
	
	List<JobAdvert> getByApplicationDeadline(Date applicationDeadline);	
	
	List<JobAdvert> getByStatus(boolean status);
	
	List<JobAdvert> getByApplicationStartDate(LocalDate applicationStartDate);
	
	List<JobAdvert> getByCity(City city);

	@Transactional
    @Modifying
    @Query("update JobAdvert j set j.isVerified=:isVerified where j.id=:id")
    void changeverify(boolean isVerified, int id);
	
	@Transactional
    @Modifying
    @Query("update JobAdvert j set j.status=:status where j.id=:id")
    void changestatus(boolean status, int id);
}
