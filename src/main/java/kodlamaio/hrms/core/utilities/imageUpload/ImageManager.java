package kodlamaio.hrms.core.utilities.imageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

@Service
public class ImageManager implements ImageService{

	private Cloudinary cloudinary;
	
	public void ImageUpload() {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "hrms-java",
				"api_key", "775631656717857",
				"api_secret", "WEkTlbGkoaydo6cUaaRIYXf9aYY"));
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public DataResult<Map> uploadImage(MultipartFile file) {
		try {
			Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ErrorDataResult<Map>();
	}

}
