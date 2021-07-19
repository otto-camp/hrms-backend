package kodlamaio.hrms.api.controllers.cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cv.CvEducationService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
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
		this.cvEducationService.add(cvEducationDto);
		return new SuccessResult("Eğitim bilgileriniz eklendi!");
	}
}
