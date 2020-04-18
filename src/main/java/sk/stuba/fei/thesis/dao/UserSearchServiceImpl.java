package sk.stuba.fei.thesis.dao;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.dao.api.UserSearchService;
import sk.stuba.fei.thesis.domain.dao.UserRepository;
import sk.stuba.fei.thesis.domain.dto.actor.UserDto;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.actors.UserType;
import sk.stuba.fei.thesis.predicates.UserPredicates;

@Component
@RequiredArgsConstructor
public class UserSearchServiceImpl implements UserSearchService {

    private final UserRepository userRepository;
    private final DozerBeanMapper mapper;

    @Override
    public Mono<User> findByIsID(Long id) {
        return this.userRepository.findOne(UserPredicates.hasIsNumber(id))
                .switchIfEmpty(Mono.error(new Exception(String.format("User with isID: %s does not exist!", id))));
    }

    @Override
    public Mono<User> findByIsName(String isName) {
        return this.userRepository.findOne(UserPredicates.hasIsName(isName));
    }

    @Override
    public Flux<User> findByQueryName(String queryName) {
        return this.userRepository.findAll(UserPredicates.hasAnyIdentityAttribute(queryName));
    }

    @Override
    public Flux<User> findByIdentityAttribute(String identityAttributeValue) {
        return this.userRepository.findAll(UserPredicates.hasAnyIdentityAttribute(identityAttributeValue));
    }

    @Override
    public Flux<UserDto> findByType(UserType type) {
        return this.userRepository.findAll(UserPredicates.hasUserType(type))
                .map(user -> this.mapper.map(user, UserDto.class));
    }

}
