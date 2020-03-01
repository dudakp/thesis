package sk.stuba.fei.thesis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.EmbeddedCourse;
import sk.stuba.fei.thesis.domain.service.CourseService;

@Api(value = "Operations obout courses")
@RequiredArgsConstructor
@RequestMapping(value = "course")
@RestController
public class CourseController {

    private final CourseService courseService;

    @ApiOperation(value = "Create course", response = EmbeddedCourse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created course!")
    })
    @PostMapping
    public Mono<Course> createCourse(@RequestBody EmbeddedCourse course) {
        return this.courseService.save(course);
    }

    @ApiOperation(value = "Returns existing course by string query. Query can be course abbreviation or course title.",
            response = Course.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved course!")
    })
    @GetMapping(value = "query")
    public Flux<Course> getCourseByPartialMatch(@RequestParam String queryString) {
        return this.courseService.getCourseByQueryString(queryString);
    }

    @ApiOperation(value = "Returns all courses..",
            response = Course.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved all courss!")
    })
    @GetMapping(value = "all")
    public Flux<Course> getCourseByPartialMatch() {
        return this.courseService.getAll();
    }

    @ApiOperation(value = "Removes course")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully removed course!"),
            @ApiResponse(code = 205, message = "Course with provided ID not found!")
    })
    @DeleteMapping
    public Mono<ResponseEntity<Void>> deleteCourse(@RequestParam String courseId) {
        return this.courseService.delete(courseId)
                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

}
