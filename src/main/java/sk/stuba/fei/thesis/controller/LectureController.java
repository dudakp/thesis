package sk.stuba.fei.thesis.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.thesis.domain.model.course.QLecture;
import sk.stuba.fei.thesis.domain.service.LectureService;

@Api(value = "Operation about lectures.")
@RequiredArgsConstructor
@RequestMapping(value = "lecture")
@RestController
public class LectureController {

    private final LectureService lectureService;

}
