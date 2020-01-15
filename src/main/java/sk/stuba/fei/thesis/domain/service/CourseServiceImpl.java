package sk.stuba.fei.thesis.domain.service;


import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.dao.CourseRepository;
import sk.stuba.fei.thesis.domain.model.actors.EmbeddedUser;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.EmbeddedCourse;
import sk.stuba.fei.thesis.domain.model.course.QCourse;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final DozerBeanMapper mapper;

    @Override
    public Mono<Course> save(EmbeddedCourse course) {
        final Course mappedCourse = mapper.map(course, Course.class);
        return this.courseRepository.save(mappedCourse);
    }

    @Override
    public Flux<Course> getCourseByQueryString(String query) {
        QCourse q = QCourse.course;
        final Flux<Course> bp1 = this.courseRepository.findAll(q.title.eq(query));
        return bp1;
    }

    @Override
    public Mono getById(String id) {
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
    public Mono<Course> updateCourse(EmbeddedUser course) {
        return null;
    }
}
