package sk.stuba.fei.thesis.domain.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.actors.User;

public interface UserRepository extends
        ReactiveMongoRepository<User, String>,
        ReactiveQuerydslPredicateExecutor<User> {
}
