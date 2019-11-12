package sk.stuba.fei.thesis.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.actors.Student;
import sk.stuba.fei.thesis.domain.service.UserServiceImpl;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final Logger loggerFactory = LoggerFactory.getLogger(this.getClass());
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public Mono createUser(@RequestBody Student user) {
        this.loggerFactory.debug(user.toString());
        return this.userService.save(user);
    }

    @PutMapping
    public Mono enrollToCourse(@RequestParam String courseId,
                                     @RequestParam String userIsId) {
        return this.userService.enrollToCourse(courseId, userIsId);
    }
//
//    @GetMapping
//    public ResponseEntity<Flux<User>> getUsers() {
//        final Flux<User> all = this.userService.findAll();
//        HttpStatus httpStatus = all != null ? HttpStatus.OK : HttpStatus.METHOD_NOT_ALLOWED;
//        return new ResponseEntity<Flux<User>>(all, httpStatus);
//    }

}
