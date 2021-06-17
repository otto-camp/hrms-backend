package kodlamaio.hrms.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/job-adverts")
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return jobAdvertService.add(jobAdvert);
	}
	
	@PostMapping("/getAll")
	public DataResult<List<JobAdvert>> getAll(){
		return jobAdvertService.getAll();
	}
	
	@PostMapping("/get-by-application-deadline")
	public DataResult<List<JobAdvert>> getByApplicationDeadline(@RequestParam Date applicationDeadline){
		return jobAdvertService.getByApplicationDeadline(applicationDeadline);
	}
	
	@PostMapping("/get-by-status")
	public DataResult<List<JobAdvert>> getByStatus(boolean status){
		return jobAdvertService.getByStatus(status);
	}
	
	@PostMapping("/get-by-city")
	public DataResult<List<JobAdvert>> getByCity(@RequestParam City city){
		return jobAdvertService.getByCity(city);
	}
}
