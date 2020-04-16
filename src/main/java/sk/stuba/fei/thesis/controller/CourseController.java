package sk.stuba.fei.thesis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.api.CourseService;
import sk.stuba.fei.thesis.domain.dto.course.CourseDto;
import sk.stuba.fei.thesis.domain.model.course.Course;

import javax.validation.Valid;

@Api(value = "Operations obout courses")
@RequiredArgsConstructor
@RequestMapping(value = "course")
@RestController
public class CourseController {

    private final CourseService courseService;

    @ApiOperation(value = "Create course", response = CourseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created course!")
    })
    @PostMapping
    public Mono<Course> createCourse(@RequestBody @Valid Course course) {
        return this.courseService.save(course);
    }

    @ApiOperation(value = "Returns existing course by string query. Query can be course abbreviation or course title.",
            response = Course.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved course!")
    })
    @GetMapping(value = "query")
    public Flux<Course> getCoursesByQueryString(@RequestParam String queryString) {
        return this.courseService.getCourseByQueryString(queryString);
    }

    @ApiOperation(value = "Returns all courses...",
            response = Course.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all courss!")
    })
    @GetMapping(value = "all")
    public Flux<Course> getAllCourses() {
        return this.courseService.getAll();
    }

}
