package sk.stuba.fei.thesis.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.dao.api.CourseSearchService;
import sk.stuba.fei.thesis.domain.dao.CourseRepository;
import sk.stuba.fei.thesis.domain.dao.UserRepository;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.predicates.CoursePredicates;
import sk.stuba.fei.thesis.predicates.UserPredicates;
import sk.stuba.fei.thesis.utils.api.AuthFacade;

@Component
@RequiredArgsConstructor
public class CourseSearchServiceImpl implements CourseSearchService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final AuthFacade authFacade;


    @Override
    public Mono<Course> findOneByAbrv(String abrv) {
        return this.courseRepository.findOne(CoursePredicates.hasAbrv(abrv));
    }

    @Override
    public Flux<Course> findAllEnrolledCourses() {
        String isName = this.authFacade.getIsName();
        return this.userRepository.findOne(UserPredicates.hasIsName(isName))
                .map(User::getEnrolledCourses)
                .flatMapMany(Flux::fromIterable);
    }

    @Override
    public Flux<Course> findAllByName(String queryName) {
        return this.courseRepository.findAll(CoursePredicates.hasTitleOrAbrv(queryName))
                .switchIfEmpty(Mono.error(new Exception("No courses with maching title or abrv.")));
    }
}
