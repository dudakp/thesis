package sk.stuba.fei.thesis.domain.api;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.Lecture;

import java.util.List;


public interface LectureService {
    Flux<Lecture> findAll();

    Flux<Course> addLectures(String courseId, List<Lecture> lectures);

    Mono<Lecture> addLab(String courseId, Lecture lecture);
}
