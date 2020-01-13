package sk.stuba.fei.thesis.domain.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import sk.stuba.fei.thesis.domain.model.course.Course;

import javax.sql.rowset.Predicate;

@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, String>,
        ReactiveQuerydslPredicateExecutor<Course> {
}

