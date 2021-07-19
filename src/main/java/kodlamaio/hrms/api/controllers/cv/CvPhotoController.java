package kodlamaio.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.cv.CvPhotoService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.cv.CvPhoto;

@RestController
@RequestMapping("/api/cvPhoto")
@CrossOrigin
public class CvPhotoController {

	private CvPhotoService cvPhotoService;
	private CandidateService candidateService;

	@Autowired
	public CvPhotoController(CvPhotoService cvPhotoService, CandidateService candidateService) {
		super();
		this.cvPhotoService = cvPhotoService;
		this.candidateService = candidateService;
	}

	@PostMapping(value = "/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "file") MultipartFile file) {
		Candidate candidate = this.candidateService.getById(id).getData();
		CvPhoto cvPhoto = new CvPhoto();
		cvPhoto.setCandidate(candidate);
		return this.cvPhotoService.add(cvPhoto, file);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvPhoto>> getAll(){
		return cvPhotoService.getAll();
	}
}
