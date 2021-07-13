package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTimeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobTime;

@RestController
@RequestMapping("/api/jobTime")
@CrossOrigin
public class JobTimeController {

	private JobTimeService jobTimeService;
	@Autowired
	public JobTimeController(JobTimeService jobTimeService) {
		super();
		this.jobTimeService = jobTimeService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobTime jobTime) {
		return jobTimeService.add(jobTime);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<JobTime>> getAll(){
		return jobTimeService.getAll();
	}
}
