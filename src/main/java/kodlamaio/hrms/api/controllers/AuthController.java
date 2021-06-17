package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping(name = "/api/auth")
public class AuthController {
	private AuthService authService;
	@Autowired
	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}
	@PostMapping("/register-candidate")
	public Result registerCandidate(@RequestBody Candidate candidate, String passwordRep) {
		return authService.registerCandidate(candidate, passwordRep);
	}
	@PostMapping("/register-employer")
	public Result registerEmployer(@RequestBody Employer employer, String passwordRep) {
		return authService.registerEmployer(employer, passwordRep);
	}
}
