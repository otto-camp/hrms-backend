package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="confirmation_code")
public class ConfirmationCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name="confirmation_code")
	private String confirmationCode;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="confirmation_date")
	private LocalDate confirmationDate = LocalDate.now();
	
	public ConfirmationCode(int userId, String confirmationCode, boolean isConfirmed, LocalDate confirmationDate) {
		super();
		this.userId = userId;
		this.confirmationCode = confirmationCode;
		this.isConfirmed = isConfirmed;
		this.confirmationDate = confirmationDate;
	}
}
