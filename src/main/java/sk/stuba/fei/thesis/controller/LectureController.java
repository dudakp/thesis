package sk.stuba.fei.thesis.controller;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.model.course.Lecture;
import sk.stuba.fei.thesis.domain.api.LectureService;

@Api(value = "Operation about lectures.")
@RequiredArgsConstructor
@RequestMapping(value = "lecture")
@RestController
public class LectureController {

}
