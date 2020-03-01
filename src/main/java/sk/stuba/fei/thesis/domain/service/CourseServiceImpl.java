package sk.stuba.fei.thesis.domain.service;


import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.dao.CourseRepository;
import sk.stuba.fei.thesis.domain.dao.LectureRepository;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.EmbeddedCourse;
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
    public Mono<Course> save(Course course) {
        final Course mappedCourse = mapper.map(course, Course.class);
        return this.courseRepository.save(mappedCourse);
    }

    @Override
    public Flux<Course> getCourseByQueryString(String query) {
        return this.courseRepository.findAll(
                this.qCourse.title.containsIgnoreCase(query)
                        .or(this.qCourse.abbreviation.containsIgnoreCase(query)));
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
