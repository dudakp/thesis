package sk.stuba.fei.thesis.domain.api;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.EducationalActivity;

import java.util.List;


public interface LectureService {
    Flux<EducationalActivity> findAll();

    Flux<Course> addLectures(String courseId, List<EducationalActivity> educationalActivities);

    Mono<EducationalActivity> addLab(String courseId, EducationalActivity educationalActivity);
}
