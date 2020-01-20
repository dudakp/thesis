package sk.stuba.fei.thesis.domain.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.Lecture;

public interface LectureRepository extends ReactiveMongoRepository<Lecture, String> {
}
