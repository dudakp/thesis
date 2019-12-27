package sk.stuba.fei.thesis.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.EmbeddedCourse;
import sk.stuba.fei.thesis.domain.service.CourseService;

@RestController
@RequestMapping(value = "course")
@Api(value = "Operations obout courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

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

}
