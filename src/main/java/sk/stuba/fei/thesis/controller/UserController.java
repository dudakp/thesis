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
import sk.stuba.fei.thesis.domain.model.actors.UserType;
import sk.stuba.fei.thesis.domain.service.UserService;

@Api(value = "!!!DONT USE THIS, ONLY FOR DEBUG!!!")
@RequiredArgsConstructor
@RequestMapping(value = "user")
@RestController
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "Create user", response = User.class)
    @PostMapping
    public Mono<User> createUser(User user) {
        return this.userService.createUser(user);
    }

    @ApiOperation(value = "Get users by userType", response = User.class)
    @GetMapping(value = "byType")
    public Flux<User> getUserByType(@RequestParam UserType query) {
        return this.userService.getUsersByType(query);
    }

    @ApiOperation(value = "Create course", response = User.class)
    @GetMapping(value = "byName")
    public Flux<User> getUserByName(@RequestParam String query) {
        return this.userService.getUserByName(query);
    }
}
