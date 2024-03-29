package kodlamaio.hrms.core.utilities.imageUpload;


import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.result.DataResult;

public interface ImageService {

	DataResult<Map<String, String>> uploadImage(MultipartFile imageFile);
}
