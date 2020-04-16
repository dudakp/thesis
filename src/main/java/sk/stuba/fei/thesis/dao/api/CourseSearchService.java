package sk.stuba.fei.thesis.dao.api;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.course.Course;

public interface CourseSearchService {

    Flux<Course> findAllEnrolledCourses();

    Flux<Course> findAllByName(String queryName);

    Mono<Course> findOneByAbrv(String abrv);
}
