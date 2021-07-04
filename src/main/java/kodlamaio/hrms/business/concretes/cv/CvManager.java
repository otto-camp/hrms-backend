package kodlamaio.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.cv.CvService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.cv.CvDao;
import kodlamaio.hrms.entities.concretes.cv.Cv;


@Service
public class CvManager implements CvService {

	private CvDao cvDao;
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Cv eklendi!");
	}

	@Override
	public Result update(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Cv güncellendi!");
	}

	@Override
	public Result delete(Cv cv) {
		this.cvDao.delete(cv);
		return new SuccessResult("Cv silindi!");
	}

	@Override
	public DataResult<Cv> getById(int id) {
		return new SuccessDataResult<Cv>(this.cvDao.getById(id));
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
	}

	@Override
	public DataResult<Cv> getByCandidateId(int id) {
		return new SuccessDataResult<Cv>(this.cvDao.getByCandidateId(id));
	}



}
