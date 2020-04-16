package sk.stuba.fei.thesis.dao.api;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.actors.User;

public interface UserSearchService {

    Mono<User> findByIsID(Long id);
    Mono<User> findByIsName(String isName);

    Flux<User> findByIdentityAttribute(String identiryAttributeValue);
}
