package kodlamaio.hrms.core.utilities.imageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;

@Service
public class ImageManager implements ImageService {

	private Cloudinary cloudinary;

	@Override
	public DataResult<Map<String, String>> uploadImage(MultipartFile imageFile) {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "hrms-java",
				"api_key", "775631656717857",
				"api_secret", "WEkTlbGkoaydo6cUaaRIYXf9aYY"));

		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(),
					ObjectUtils.emptyMap());
			return new SuccessDataResult<Map<String, String>>(resultMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return new ErrorDataResult<Map<String, String>>();

	}
}
