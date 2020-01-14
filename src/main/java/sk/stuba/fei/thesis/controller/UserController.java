package sk.stuba.fei.thesis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.course.EmbeddedCourse;
import sk.stuba.fei.thesis.domain.service.UserService;

@Api(value = "!!!DONT USE THIS, ONLY FOR DEBUG!!!")
@RequiredArgsConstructor
@RequestMapping(value = "user")
@RestController
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "Create course", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created course!")
    })
    @PostMapping
    public Mono createUser(User user) {
        return this.userService.createUser(user);
    }

    @ApiOperation(value = "Create course", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created course!")
    })
    @GetMapping
    public Flux<User> queryUser(@RequestParam String query) {
        return this.userService.getUsersByQueryString(query);
    }
}
