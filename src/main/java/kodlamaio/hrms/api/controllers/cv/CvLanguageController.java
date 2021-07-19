package kodlamaio.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cv.CvLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.cv.CvLanguage;

@RestController
@RequestMapping("/api/cvLang")
@CrossOrigin
public class CvLanguageController {

	private CvLanguageService cvLanguageService;

	@Autowired
	public CvLanguageController(CvLanguageService cvLanguageService) {
		super();
		this.cvLanguageService = cvLanguageService;
	}
	@PostMapping("/add")
	public Result add(@RequestBody CvLanguage cvLanguage) {
		return cvLanguageService.add(cvLanguage);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvLanguage>> getAll(){
		return cvLanguageService.getAll();
	}
}
