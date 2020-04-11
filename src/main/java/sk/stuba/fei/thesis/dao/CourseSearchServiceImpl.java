package sk.stuba.fei.thesis.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import sk.stuba.fei.thesis.dao.api.CourseSearchService;
import sk.stuba.fei.thesis.domain.dao.UserRepository;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.predicates.UserPredicates;
import sk.stuba.fei.thesis.utils.api.AuthFacade;

@Component
@RequiredArgsConstructor
public class CourseSearchServiceImpl implements CourseSearchService {

    private final UserRepository userRepository;
    private final AuthFacade authFacade;

    @Override
    public Flux<Course> findAllEnrolledCourses() {
        String isName = this.authFacade.getIsName();
        return this.userRepository.findOne(UserPredicates.hasIsName(isName))
                .map(User::getEnrolledCourses)
                .flatMapMany(Flux::fromIterable);
    }
}
