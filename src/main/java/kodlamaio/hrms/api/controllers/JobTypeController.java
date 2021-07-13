package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTypeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobType;

@RestController
@RequestMapping("/api/jobType")
@CrossOrigin
public class JobTypeController {

	private JobTypeService jobTypeService;
	@Autowired
	public JobTypeController(JobTypeService jobTypeService) {
		super();
		this.jobTypeService = jobTypeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobType jobType) {
		return jobTypeService.add(jobType);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobType>> getAll(){
		return jobTypeService.getAll();
	}
}
