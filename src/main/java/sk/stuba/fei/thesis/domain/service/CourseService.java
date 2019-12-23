package sk.stuba.fei.thesis.domain.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.EmbeddedCourse;

public interface CourseService {

    Mono save(EmbeddedCourse course);

    Mono<EmbeddedCourse> getById(String id);

    Mono getByName(String name);

    Flux getByLecturerName(String lecturerName);
}
