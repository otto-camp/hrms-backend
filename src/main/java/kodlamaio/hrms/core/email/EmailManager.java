package kodlamaio.hrms.core.email;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service 
public class EmailManager implements EmailService{
	//@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(String email, String body, String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("ismailyarar4@gmail.com");
		message.setTo(email);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
	} 
}
