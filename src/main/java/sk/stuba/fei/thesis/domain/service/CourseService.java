package sk.stuba.fei.thesis.domain.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.EmbeddedCourse;
import sk.stuba.fei.thesis.domain.model.course.Lecture;

public interface CourseService {

    Mono<Course> save(EmbeddedCourse course);

    Mono<Course> getById(String id);

    Flux<Course> getByAbbrv(String abbrv);

    Mono<Course> getByName(String name);

    Flux<Course> getByLecturerName(String lecturerName);

    Flux<Course> getCourseByQueryString(String query);

    Mono<Course> updateCourse(EmbeddedCourse course);

    Mono<Lecture> addLecture(String courseQuery, Lecture lecture);

    Mono<Lecture> addLab(String courseId, Lecture lecture);
}
