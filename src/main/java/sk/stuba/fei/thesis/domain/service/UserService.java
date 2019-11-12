package sk.stuba.fei.thesis.domain.service;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.actors.User;

public interface UserService {
    Flux<User> findAll();

    Mono save(User user);

    Mono getById(String userId);

    Mono getByIsId(Long isId);

    Flux getByName(String fullName);

    Mono enrollToCourse(String courseId, String userIsID);
}
