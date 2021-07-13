package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmationCodeService;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.ConfirmationDao;
import kodlamaio.hrms.entities.concretes.ConfirmationCode;

@Service
public class ConfirmationCodeManager implements ConfirmationCodeService{

	private ConfirmationDao confirmationDao;
	@Autowired
	public ConfirmationCodeManager(ConfirmationDao confirmationDao) {
		super();
		this.confirmationDao = confirmationDao;
	}
	
	@Override
	public Result add(ConfirmationCode confirmationCode) {
		this.confirmationDao.save(confirmationCode);
		return new SuccessResult("Kod kaydedildi!");
	}
	
}
