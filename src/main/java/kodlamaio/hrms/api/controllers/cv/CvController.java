package kodlamaio.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.cv.CvService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.cv.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/cv")
public class CvController {
	private CvService cvService;
	
	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvDto cvDto) {
		return this.cvService.add(cvDto);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Cv>> getAll(@RequestParam int candidateId){
		return this.cvService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<CvDto> getCvByCandidateId(@RequestParam int candidateId){
		return this.cvService.getCvByCandidateId(candidateId);
	}
}
