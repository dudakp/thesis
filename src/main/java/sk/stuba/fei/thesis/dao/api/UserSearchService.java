package sk.stuba.fei.thesis.dao.api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.dto.actor.UserDto;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.actors.UserType;

public interface UserSearchService {

    Mono<User> findByIsID(Long id);
    Mono<User> findByIsName(String isName);

    Flux<User> findByQueryName(String queryName);

    Flux<User> findByIdentityAttribute(String identiryAttributeValue);

    Flux<UserDto> findByType(UserType type);
}
