package kodlamaio.hrms.business.concretes.cv;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.cv.CvPhotoService;
import kodlamaio.hrms.core.utilities.imageUpload.ImageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstacts.cv.CvPhotoDao;
import kodlamaio.hrms.entities.concretes.cv.CvPhoto;

@Service
public class CvPhotoManager implements CvPhotoService{

	private CvPhotoDao cvPhotoDao;
	private ImageService  imageService;
	
	@Autowired
	public CvPhotoManager(CvPhotoDao cvPhotoDao, ImageService imageService) {
		super();
		this.cvPhotoDao = cvPhotoDao;
		this.imageService = imageService;
	}

	@Override
	
	public Result add(CvPhoto cvPhoto, MultipartFile file) {
		Map<String, String> uploadImage = this.imageService.uploadImage(file).getData();
		cvPhoto.setPhotoUrl(uploadImage.get("url"));
		this.cvPhotoDao.save(cvPhoto);
		return new SuccessResult("Fotoğrafınız kaydedildi!");
	}

	@Override
	public Result update(CvPhoto cvPhoto) {
		this.cvPhotoDao.save(cvPhoto);
		return new SuccessResult("Fotoğrafınızı güncellendi!");
	}

	@Override
	public Result delete(int id) {
		this.cvPhotoDao.deleteById(id);
		return new SuccessResult("Fotoğrafınız silindi1");
	}

	@Override
	public DataResult<CvPhoto> getById(int id) {
		return new SuccessDataResult<CvPhoto>(this.cvPhotoDao.getById(id));
	}

	@Override
	public DataResult<List<CvPhoto>> getAll() {
		return new SuccessDataResult<List<CvPhoto>>(this.cvPhotoDao.findAll());
	}

	@Override
	public DataResult<CvPhoto> getByCandidateId(int id) {
		return new SuccessDataResult<CvPhoto>(this.cvPhotoDao.getByCandidateId(id));
	}

}
