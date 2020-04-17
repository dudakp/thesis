package sk.stuba.fei.thesis.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.api.CourseService;
import sk.stuba.fei.thesis.domain.api.LectureService;
import sk.stuba.fei.thesis.domain.dao.LectureRepository;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.EducationalActivity;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectureServiceImpl implements LectureService {

    private final CourseService courseService;
    private final LectureRepository lectureRepository;

    @Override
    public Flux<EducationalActivity> findAll() {
        return this.lectureRepository.findAll();
    }

    @Override
    public Flux<Course> addLectures(String courseId, List<EducationalActivity> educationalActivities) {
        return null;
//        return this.getById(courseId)
//                .map(course -> {
//                    course.getLectures().addAll(lectures);
//                    return course;
//                })
//                .flatMap(this.courseRepository::save)
//                .doOnError(throwable -> Mono.error(new Exception("Failed to update lecture in DB")))
////                .flatMap(course -> this.lectureRepository.saveAll(lectures))
//                .flatMap(course -> this.lectureRepository.save(lectures))
//                .doOnError(throwable -> Mono.error(new Exception("Failed to add lecture to DB")));
    }

    @Override
    public Mono<EducationalActivity> addLab(String courseId, EducationalActivity educationalActivity) {
        return this.courseService.getById(courseId)
                .map(course -> {
                    course.getLabs().add(educationalActivity);
                    return course;
                })
                .flatMap(this.courseService::save)
                .doOnError(throwable -> Mono.error(new Exception("Failed to update lecture in DB")))
                .flatMap(course -> this.lectureRepository.save(educationalActivity))
                .doOnError(throwable -> Mono.error(new Exception("Failed to add lecture to DB")));
    }
}
