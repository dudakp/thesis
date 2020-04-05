package sk.stuba.fei.thesis.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.dao.api.CourseSearchService;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.api.UserService;
import sk.stuba.fei.thesis.domain.model.course.Course;

@Api(value = "!!!DONT USE THIS, ONLY FOR DEBUG!!!")
@RequiredArgsConstructor
@RequestMapping(value = "user")
@RestController
public class UserController {

    private final UserService userService;
    private final CourseSearchService courseSearchService;

    @GetMapping(value = "hello")
    private void hello() {

    }

    @PostMapping(value = "enroll")
    public Mono<User> enrollToCourse(@RequestParam String courseAbrv) {
        return this.userService.enrollToCourse(courseAbrv);
    }

    @GetMapping(value = "getCourses")
    public Flux<Course> getEnrolledCourses() {
        return this.courseSearchService.findAllEnrolledCourses();
    }
}
