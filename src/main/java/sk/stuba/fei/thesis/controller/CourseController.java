package sk.stuba.fei.thesis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
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
    public Mono createCourse(@RequestBody EmbeddedCourse course) {
        return this.courseService.save(course);
    }


    @ApiOperation(value = "Get course by abbreviation", response = EmbeddedCourse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Course retrieved successfully ")
    })
    @GetMapping
    public Flux getCourseByAbbrv(@RequestParam String abbrv) {
        return this.courseService.getByAbbrv("BP2");
    }

    @ApiOperation(value = "Update course", response = EmbeddedCourse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated course!")
    })
    @PutMapping(value = "update")
    public Mono updateCourse() {
        return null;
    }

    @ApiOperation(value = "Removes course", response = EmbeddedCourse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully removed course!")
    })
    @DeleteMapping
    public Mono deleteCourse() {
        return null;
    }

    @ApiOperation(value = "Returns existing course by string query. Query can be course abbreviation or course title.",
            response = EmbeddedCourse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved course!")
    })
    @GetMapping(value = "query")
    public Flux<Course> getCourseByPartialMatch(@RequestParam String queryString) {
        return this.courseService.getCourseByQueryString(queryString);
    }

}
