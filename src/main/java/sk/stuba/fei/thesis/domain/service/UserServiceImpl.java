package sk.stuba.fei.thesis.domain.service;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.dao.api.UserSearchService;
import sk.stuba.fei.thesis.domain.api.UserService;
import sk.stuba.fei.thesis.domain.dao.CourseRepository;
import sk.stuba.fei.thesis.domain.dao.UserRepository;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.actors.UserType;
import sk.stuba.fei.thesis.utils.api.AuthFacade;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final UserSearchService userSearchService;
    private final AuthFacade authFacade;
    private final DozerBeanMapper mapper;

    @Override
    public Mono<User> enrollToCourse(String courseAbrv) {
        String isName = this.authFacade.getIsName();
        return this.courseRepository.getByAbbreviation(courseAbrv).flatMap(course ->
                this.userSearchService.findByIsName(isName)
                        .switchIfEmpty(Mono.error(new Exception("User not found!")))
                        .flatMap(user -> {
                            user.getEnrolledCourses().add(course);
                            return this.userRepository.save(user);
                        }));
    }


}
