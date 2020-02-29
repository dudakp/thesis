package sk.stuba.fei.thesis.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.course.Lecture;
import sk.stuba.fei.thesis.domain.service.LectureService;

@Api(value = "Operation about lectures.")
@RequiredArgsConstructor
@RequestMapping(value = "lecture")
@RestController
public class LectureController {

    private final LectureService lectureService;

    @ApiOperation(value = "Add lecture to course", response = Lecture.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lecture added to course"),
            @ApiResponse(code = 204, message = "Course with provided ID does not exist")
    })
    @PostMapping(value = "add")
    public Mono<ResponseEntity<Lecture>> updateCourse(@RequestParam @ApiParam(example = "5e2445e45396ee0fb4617b8f") String courseId,
                                                      @RequestBody Lecture lecture) {
        return this.lectureService.addLab(courseId, lecture)
                .map(lecture1 -> ResponseEntity.ok(lecture))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @ApiOperation(value = "Get all lectures", response = Lecture.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated course!")
    })
    @GetMapping
    public Flux<Lecture> findAll() {
        return this.lectureService.findAll();
    }

    @ApiOperation(value = "Update lecture", response = Lecture.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated course!")
    })
    @PutMapping
    public Mono<Lecture> update(Lecture lecture) {
        return null;
    }

}
