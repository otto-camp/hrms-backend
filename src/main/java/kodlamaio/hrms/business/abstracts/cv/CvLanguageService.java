package kodlamaio.hrms.business.abstracts.cv;


import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.cv.CvLanguage;

public interface CvLanguageService {
	Result add(CvLanguage cvLanguage);
	Result update(CvLanguage cvLanguage);
	Result delete(int id);
	
	DataResult<CvLanguage> getById(int id);
	DataResult<List<CvLanguage>> getAll();
	DataResult<List<CvLanguage>> getByCandidateId(int id);
}
