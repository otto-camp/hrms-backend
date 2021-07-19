package kodlamaio.hrms.api.controllers.cv;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cv.CvExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.cv.CvExperience;
import kodlamaio.hrms.entities.dtos.CvExperienceDto;

@RestController
@RequestMapping("/api/cvExp")
@CrossOrigin
public class CvExperienceController {

	private CvExperienceService cvExperienceService;

	@Autowired
	public CvExperienceController(CvExperienceService cvExperienceService) {
		super();
		this.cvExperienceService = cvExperienceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvExperienceDto cvExperienceDto) {
		return cvExperienceService.add(cvExperienceDto);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvExperience>> getAll(){
		return cvExperienceService.getAll();
	}
}
