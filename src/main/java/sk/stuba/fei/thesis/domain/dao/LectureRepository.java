package sk.stuba.fei.thesis.domain.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.Lecture;

import java.util.List;

@Repository
public interface LectureRepository extends ReactiveMongoRepository<Lecture, String> {

}
