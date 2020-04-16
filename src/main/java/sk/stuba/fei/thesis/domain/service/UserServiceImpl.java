package sk.stuba.fei.thesis.domain.service;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.dao.api.CourseSearchService;
import sk.stuba.fei.thesis.dao.api.UserSearchService;
import sk.stuba.fei.thesis.domain.api.UserService;
import sk.stuba.fei.thesis.domain.dao.CourseRepository;
import sk.stuba.fei.thesis.domain.dao.UserRepository;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.utils.api.AuthFacade;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    private final UserSearchService userSearchService;
    private final CourseSearchService courseSearchService;

    private final AuthFacade authFacade;
    private final DozerBeanMapper mapper;

    @Override
    public Mono<User> enrollToCourse(String courseAbrv) {
        String isName = this.authFacade.getIsName();
        return this.courseSearchService.findOneByAbrv(courseAbrv).flatMap(course ->
                this.userSearchService.findByIsName(isName)
                        .switchIfEmpty(Mono.error(new Exception("User not found!")))
                        .flatMap(user -> Flux.fromIterable(user.getEnrolledCourses())
                                .filter(c -> !course.getAbbreviation().equals(c.getAbbreviation()))
                                .switchIfEmpty(Mono.error(new Exception("Course already enrolled!")))
                                .flatMap(subscriber -> {
                                    user.getEnrolledCourses().add(course);
                                    return this.userRepository.save(user);
                                }).next()));
    }

    @Override
    public Flux<User> getByPartialNameMatch(String queryName) {
        return this.userSearchService.findByIdentityAttribute(queryName);
    }


}
