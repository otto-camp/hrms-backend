package kodlamaio.hrms.api.controllers.cv;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cv.CvExperienceService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.concretes.cv.CvExperience;

@RestController
@RequestMapping("/api/cvExp")
public class CvExperienceController {

	private CvExperienceService cvExperienceService;

	@Autowired
	public CvExperienceController(CvExperienceService cvExperienceService) {
		super();
		this.cvExperienceService = cvExperienceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvExperience cvExperience) {
		this.cvExperienceService.add(cvExperience);
		return new SuccessResult("İş tecrübeleriniz eklendi!");
	}
}