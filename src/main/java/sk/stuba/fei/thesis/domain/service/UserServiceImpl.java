package sk.stuba.fei.thesis.domain.service;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.dao.UserRepository;
import sk.stuba.fei.thesis.domain.model.actors.QUser;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.QCourse;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DozerBeanMapper mapper;

    @Override
    public Mono createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Flux<User> getUsersByQueryString(String queryString) {
        QUser qUser = QUser.user;
        return this.userRepository.findAll(qUser.firstName.containsIgnoreCase(queryString)
                .or(qUser.lastName.containsIgnoreCase(queryString)));
    }
}
