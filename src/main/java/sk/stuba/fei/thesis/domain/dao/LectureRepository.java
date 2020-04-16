package sk.stuba.fei.thesis.domain.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.thesis.domain.model.course.EducationalActivity;

@Repository
public interface LectureRepository extends ReactiveMongoRepository<EducationalActivity, String> {

}
