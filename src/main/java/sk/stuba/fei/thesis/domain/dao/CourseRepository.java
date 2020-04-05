package sk.stuba.fei.thesis.domain.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.course.Course;

@Repository
public interface CourseRepository extends ReactiveMongoRepository<Course, String>,
        ReactiveQuerydslPredicateExecutor<Course> {
    Mono<Course> getByAbbreviation(String abbreviation);
}

