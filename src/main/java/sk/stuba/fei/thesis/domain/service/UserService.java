package sk.stuba.fei.thesis.domain.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.actors.UserType;

public interface UserService {

    Mono<User> createUser(User user);

    Mono<User> getUserByIsID(Long id);

    Flux<User> getUsersByType(UserType type);

    Flux<User> getUserByName(String queryString);
}
