package kodlamaio.hrms.dataAccess.abstacts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ConfirmationCode;

public interface ConfirmationDao extends JpaRepository<ConfirmationCode, Integer> {

	ConfirmationCode getByConfirmationCode(String confirmationCode);

	List<ConfirmationCode> getByIsConfirmed(boolean isConfirmed);

	ConfirmationCode getByUserIdAndId(int userId, int id);

}
