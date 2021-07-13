package kodlamaio.hrms.core.email;

public interface EmailService {
	void sendEmail(String email, String body, String subject);
}
