package sk.stuba.fei.thesis.domain.api;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.dto.course.CourseDto;

public interface CourseService {

    Mono<Course> save(CourseDto course);

    Flux<Course> getAll();

    Mono<Course> getById(String id);

    Mono<Course> save(Course course);

    Flux<Course> getCourseByQueryString(String query);

    Mono<Void> delete(String id);

    Mono<Void> delete(Course course);
}
