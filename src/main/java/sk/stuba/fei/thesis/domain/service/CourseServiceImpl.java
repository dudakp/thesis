package sk.stuba.fei.thesis.domain.service;


import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.dao.CourseRepository;
import sk.stuba.fei.thesis.domain.dao.LectureRepository;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.EmbeddedCourse;
import sk.stuba.fei.thesis.domain.model.course.Lecture;
import sk.stuba.fei.thesis.domain.model.course.QCourse;


@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final LectureRepository lectureRepository;
    private final DozerBeanMapper mapper;
    private final QCourse qCourse;

    public CourseServiceImpl(CourseRepository courseRepository, LectureRepository lectureRepository, DozerBeanMapper mapper) {
        this.courseRepository = courseRepository;
        this.lectureRepository = lectureRepository;
        this.mapper = mapper;
        this.qCourse = QCourse.course;

    }

    @Override
    public Mono<Course> save(EmbeddedCourse course) {
        final Course mappedCourse = mapper.map(course, Course.class);
        return this.courseRepository.save(mappedCourse);
    }

    @Override
    public Flux<Course> getCourseByQueryString(String query) {
        final Flux<Course> bp1 = this.courseRepository.findAll(this.qCourse.title.eq(query));
        return bp1;
    }

    @Override
    public Mono<Course> getById(String id) {
        return this.courseRepository.findById(id);
    }

    @Override
    public Flux getByAbbrv(String abbrv) {
        return null;
    }

    @Override
    public Mono getByName(String name) {
        return null;
    }

    @Override
    public Flux getByLecturerName(String lecturerName) {
        return null;
    }

    @Override
    public Mono<Lecture> addLecture(String courseId, Lecture lecture) {
        return this.getById(courseId)
                .map(course -> {
                    course.getLectures().add(lecture);
                    return course;
                })
                .flatMap(this.courseRepository::save)
                .doOnError(throwable -> Mono.error(new Exception("Failed to update lecture in DB")))
                .flatMap(course -> this.lectureRepository.save(lecture))
                .doOnError(throwable -> Mono.error(new Exception("Failed to add lecture to DB")));
    }

    @Override
    public Mono<Lecture> addLab(String courseId, Lecture lecture) {
        return this.getById(courseId)
                .map(course -> {
                    course.getLabs().add(lecture);
                    return course;
                })
                .flatMap(this.courseRepository::save)
                .doOnError(throwable -> Mono.error(new Exception("Failed to update lecture in DB")))
                .flatMap(course -> this.lectureRepository.save(lecture))
                .doOnError(throwable -> Mono.error(new Exception("Failed to add lecture to DB")));
    }

    @Override
    public Mono<Course> updateCourse(EmbeddedCourse course) {
        final Mono<Course> courseToModify = this.courseRepository
                .findOne(this.qCourse.abbreviation.eq(course.getAbbreviation()));
//        this.courseRepository.
        return null;
    }
}
