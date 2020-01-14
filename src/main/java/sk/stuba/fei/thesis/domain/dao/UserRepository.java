package sk.stuba.fei.thesis.domain.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.course.Course;

public interface UserRepository extends ReactiveMongoRepository<User, String>,
        ReactiveQuerydslPredicateExecutor<User> {
}
