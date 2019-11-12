package sk.stuba.fei.thesis.domain.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.course.Course;

public interface CourseService {

    Mono save(Course course);

    Mono<Course> getById(String id);

    Mono getByName(String name);

    Flux getByLecturerName(String lecturerName);
}
