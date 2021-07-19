package kodlamaio.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cv.CvEducationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.cv.CvEducation;
import kodlamaio.hrms.entities.dtos.CvEducationDto;

@RestController
@RequestMapping("/api/cvEdu")
@CrossOrigin
public class CvEducationController {

	private CvEducationService cvEducationService;

	@Autowired
	public CvEducationController(CvEducationService cvEducationService) {
		super();
		this.cvEducationService = cvEducationService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvEducationDto cvEducationDto) {
		return cvEducationService.add(cvEducationDto); 
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvEducation>> getAll(){
		return cvEducationService.getAll();
	}
}
