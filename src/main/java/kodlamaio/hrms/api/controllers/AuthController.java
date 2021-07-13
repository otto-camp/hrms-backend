package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.dtos.CandidateRegisterDto;
import kodlamaio.hrms.entities.dtos.EmployerRegisterDto;

@RestController
@RequestMapping(name = "/api/auth")
@CrossOrigin
public class AuthController {
	private AuthService authService;
	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	@PostMapping("/register-candidate")
	public Result add(@RequestBody CandidateRegisterDto candidateRegisterDto) {
		this.authService.registerCandidate(candidateRegisterDto);
		return new SuccessResult("İş arayan eklendi!");
	}
	@PostMapping("/register-employer")
	public Result add(@RequestBody EmployerRegisterDto employerRegisterDto) {
		this.authService.registerEmployer(employerRegisterDto);
		return new SuccessResult("İşveren kaydedildi!");
	}
}
