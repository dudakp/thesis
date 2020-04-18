package sk.stuba.fei.thesis.domain.api;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.actors.UserType;

public interface UserService {

    Mono<User> enrollToCourse(String courveAbrv);

    Mono<User> changeUserType(Long userIsID, UserType userType);

    Flux<User> getAll();
}
