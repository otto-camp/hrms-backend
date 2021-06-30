package kodlamaio.hrms.business.abstracts.cv;


import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.cv.Cv;

public interface CvService {
	
	Result add(Cv cv);

}
