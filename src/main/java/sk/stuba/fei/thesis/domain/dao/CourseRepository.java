package sk.stuba.fei.thesis.domain.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.thesis.domain.model.course.Course;

@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, String>,
        ReactiveQuerydslPredicateExecutor<Course> {
}

