package sk.stuba.fei.thesis.dao.api;

import reactor.core.publisher.Flux;
import sk.stuba.fei.thesis.domain.model.course.Course;

public interface CourseSearchService {

    Flux<Course> findAllEnrolledCourses();
}
