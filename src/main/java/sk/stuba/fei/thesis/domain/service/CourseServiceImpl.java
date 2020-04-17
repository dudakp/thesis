package sk.stuba.fei.thesis.domain.service;


import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.dao.api.CourseSearchService;
import sk.stuba.fei.thesis.dao.api.UserSearchService;
import sk.stuba.fei.thesis.domain.api.CourseService;
import sk.stuba.fei.thesis.domain.dao.CourseRepository;
import sk.stuba.fei.thesis.domain.dao.LectureRepository;
import sk.stuba.fei.thesis.domain.dto.actor.UserDto;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.predicates.CoursePredicates;

import java.util.Optional;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final LectureRepository lectureRepository;

    private final UserSearchService userSearchService;
    private final CourseSearchService courseSearchService;
    private final DozerBeanMapper mapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Mono<Course> save(Course course) {
        Course.CourseBuilder lectureBuildObject = Course.builder()
                .title(course.getTitle())
                .abbreviation(course.getAbbreviation())
                .description(course.getDescription())
                .semester(course.getSemester())
                .exams(course.getExams())
                .finalExam(course.getFinalExam())
                .isCourseLink(course.getIsCourseLink());

        return this.courseRepository.findOne(CoursePredicates.hasAbrv(course.getAbbreviation()))
                .flatMap(__ -> Mono.error(new Exception(String.format("Course '%s' already exists!", __.getTitle()))))
                .cast(Course.class)
                .switchIfEmpty(
                        this.userSearchService.findByIsID(course.getLecturer().getIsID())
                                .map(lecturer ->
                                        lectureBuildObject.lecturer(this.mapper.map(lecturer, UserDto.class))
                                )
                                .flatMap(__ ->
                                        this.userSearchService.findByIsID(course.getGuarantor().getIsID()))
                                .map(guarantor ->
                                        lectureBuildObject.guarantor(this.mapper.map(guarantor, UserDto.class)))
                                .flatMap(__ -> {
                                    lectureBuildObject.lectures(course.getLectures());
                                    return this.lectureRepository.save(course.getLectures().get(0));
                                })
                                .flatMap(__ -> Mono.justOrEmpty(course.getLabs())
                                        .map(educationalActivities -> {
                                            lectureBuildObject.labs(course.getLabs());
                                            return this.lectureRepository.saveAll(course.getLabs());
                                        }))
                                .flatMap(__ ->
                                        this.courseRepository.save(lectureBuildObject.build())
                                )
                );
    }

    @Override
    public Flux<Course> getCourseByQueryString(String query) {
        return this.courseSearchService.findAllByName(query);
    }

    @Override
    public Flux<Course> getAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Mono<Course> getById(String id) {
        return this.courseRepository.findById(id);
    }


    @Override
    public Mono<Void> delete(String id) {
        return this.getById(id)
                .flatMap(course -> this.courseRepository.delete(course)
                        .then(Mono.empty()));
    }

    @Override
    public Mono<Void> delete(Course course) {
        return this.getById(course.get_id())
                .flatMap(this.courseRepository::delete);
    }

}
