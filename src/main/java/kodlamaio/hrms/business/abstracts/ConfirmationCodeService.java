package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.ConfirmationCode;

public interface ConfirmationCodeService {
	Result add(ConfirmationCode confirmationCode);
}
