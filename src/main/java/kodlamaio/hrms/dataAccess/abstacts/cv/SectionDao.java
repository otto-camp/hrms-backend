package kodlamaio.hrms.dataAccess.abstacts.cv;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.Section;

public interface SectionDao extends JpaRepository<Section, Integer>{
	Section getById(int id);
}
