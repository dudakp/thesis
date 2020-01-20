package sk.stuba.fei.thesis.domain.service;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.dao.UserRepository;
import sk.stuba.fei.thesis.domain.model.actors.QUser;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.actors.UserType;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DozerBeanMapper mapper;
    private final QUser qUser;

    public UserServiceImpl(UserRepository userRepository, DozerBeanMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.qUser = QUser.user;
    }

    @Override
    public Mono<User> createUser(User user) {
        return this
                .getUserByIsID(user.getIsID())
                .flatMap(result -> Mono.error(new Exception("User already exists")))
                .cast(User.class)
                .switchIfEmpty(
                        this.userRepository.save(user)
                );
    }

    @Override
    public Mono<User> getUserByIsID(Long id) {
        return this.userRepository.findOne(this.qUser.isID.eq(id));
    }

    @Override
    public Flux<User> getUsersByType(UserType type) {
        return this.userRepository.findAll(this.qUser.userType.eq(type));
    }

    @Override
    public Flux<User> getUserByName(String queryString) {
        return this.userRepository.findAll(this.qUser.firstName.containsIgnoreCase(queryString)
                .or(qUser.lastName.containsIgnoreCase(queryString)));
    }


}
