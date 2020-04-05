package sk.stuba.fei.thesis.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.dao.api.UserSearchService;
import sk.stuba.fei.thesis.domain.dao.UserRepository;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.predicates.UserPredicates;

@Component
@RequiredArgsConstructor
public class UserSearchServiceImpl implements UserSearchService {
    private final UserRepository userRepository;

    @Override
    public Mono<User> findByIsID(Long id) {
        return this.userRepository.findOne(UserPredicates.hasIsNumber(id));
    }

    @Override
    public Mono<User> findByIsName(String isName) {
        return this.userRepository.findOne(UserPredicates.hasIsName(isName));
    }
}
