package kodlamaio.hrms.core.confirmation;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ConfirmationManager implements ConfirmationService{

	@Override
	public void sendConfirmationLink(String email) {
		UUID uuid = UUID.randomUUID();
		String confirmationLink = "https://hrmsconfirm/" + uuid.toString();
		System.out.println("Please click on the link to verify your account:  " + confirmationLink );
	}

	@Override
	public String sendCode() {
		UUID uuid = UUID.randomUUID();
		String confirmationCode = uuid.toString();
		System.out.println("Your code : " + confirmationCode);
		return confirmationCode;
	}

}
