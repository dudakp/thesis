package sk.stuba.fei.thesis.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.dao.api.CourseSearchService;
import sk.stuba.fei.thesis.dao.api.UserSearchService;
import sk.stuba.fei.thesis.domain.api.UserService;
import sk.stuba.fei.thesis.domain.dao.UserRepository;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.actors.UserType;
import sk.stuba.fei.thesis.utils.api.AuthFacade;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserSearchService userSearchService;
    private final CourseSearchService courseSearchService;

    private final AuthFacade authFacade;

    @Override
    public Mono<User> enrollToCourse(String courseAbrv) {
        String isName = this.authFacade.getIsName();

        return this.courseSearchService.findOneByAbrv(courseAbrv).flatMap(course ->
                this.userSearchService.findByIsName(isName)
                        .switchIfEmpty(Mono.error(new Exception("User not found!")))
                        .filter(user -> user.getEnrolledCourses().stream()
                                .noneMatch(c -> c.getAbbreviation().equals(course.getAbbreviation())))
                        .switchIfEmpty(Mono.error(new Exception("Already enrolled!")))
                        .flatMap(user -> {
                            user.getEnrolledCourses().add(course);
                            return this.userRepository.save(user);
                        })
                        .checkpoint()
        );
    }

    @Override
    public Mono<User> changeUserType(Long userIsID, UserType userType) {
        return this.userSearchService.findByIsID(userIsID)
                .switchIfEmpty(Mono.error(new Exception("User does not exist in DB!")))
                .map(user -> {
                    user.setUserType(userType);
                    return user;
                })
                .flatMap(this.userRepository::save);
    }

    @Override
    public Flux<User> getAll() {
        return this.userRepository.findAll();
    }

}
