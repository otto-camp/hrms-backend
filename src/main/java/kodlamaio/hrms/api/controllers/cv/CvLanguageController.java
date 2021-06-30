package kodlamaio.hrms.api.controllers.cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cv.CvLanguageService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.concretes.cv.CvLanguage;

@RestController
@RequestMapping("/api/cvLang")
public class CvLanguageController {

	private CvLanguageService cvLanguageService;

	@Autowired
	public CvLanguageController(CvLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody CvLanguage cvLanguage) {
		this.cvLanguageService.add(cvLanguage);
		return new SuccessResult("Dil bilgileriniz eklendi!");
	}
}
