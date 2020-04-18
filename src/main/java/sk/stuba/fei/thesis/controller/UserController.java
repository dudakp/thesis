package sk.stuba.fei.thesis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.dao.api.CourseSearchService;
import sk.stuba.fei.thesis.dao.api.UserSearchService;
import sk.stuba.fei.thesis.domain.api.UserService;
import sk.stuba.fei.thesis.domain.dto.actor.UserDto;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.actors.UserType;
import sk.stuba.fei.thesis.domain.model.course.Course;

@RequiredArgsConstructor
@RequestMapping(value = "user")
@RestController
public class UserController {

    private final UserService userService;
    private final UserSearchService userSearchService;
    private final CourseSearchService courseSearchService;

    @GetMapping(value = "hello")
    private void hello() {

    }

    @GetMapping(value = "getCourses")
    public Flux<Course> getEnrolledCourses() {
        return this.courseSearchService.findAllEnrolledCourses();
    }

    @GetMapping(value = "getByName")
    public Flux<User> getByName(@RequestParam String queryName) {
        return this.userSearchService.findByIdentityAttribute(queryName);
    }

    @GetMapping(value = "getByType")
    public Flux<UserDto> getByType(@RequestParam UserType type) {
        return this.userSearchService.findByType(type);
    }

    @PostMapping(value = "enroll")
    public Mono<User> enrollToCourse(@RequestParam String courseAbrv) {
        return this.userService.enrollToCourse(courseAbrv);
    }

    @PutMapping
    public Mono<User> changeUserType(@RequestParam Long userIsID, @RequestParam UserType userType) {
        return this.userService.changeUserType(userIsID, userType);
    }


}
