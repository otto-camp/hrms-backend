package kodlamaio.hrms.core.confirmation;

public interface ConfirmationService {
	void sendConfirmationLink(String email);
	String sendCode();
}
