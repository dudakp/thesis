package sk.stuba.fei.thesis.domain.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.actors.User;

public interface UserService {

    Mono createUser(User user);

    Flux<User> getUsersByQueryString(String queryString);
}
