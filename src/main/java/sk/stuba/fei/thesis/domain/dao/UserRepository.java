package sk.stuba.fei.thesis.domain.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.thesis.domain.model.actors.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
