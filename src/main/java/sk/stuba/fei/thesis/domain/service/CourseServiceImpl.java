package sk.stuba.fei.thesis.domain.service;


import com.querydsl.core.types.dsl.BooleanExpression;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.dao.CourseRepository;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.EmbeddedCourse;
import sk.stuba.fei.thesis.domain.model.course.QCourse;

import java.util.function.Predicate;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final DozerBeanMapper mapper;

//    Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    public CourseServiceImpl(CourseRepository courseRepository, DozerBeanMapper mapper) {
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    @Override
    public Mono save(EmbeddedCourse course) {
        final Course mappedCourse = this.mapper.map(course, Course.class);
        return this.courseRepository.save(mappedCourse);
    }

    @Override
    public Flux getByAbbrv(String abbrv) {
//        QCourse qCourse = new QCourse(abbrv);
//        final BooleanExpression eq = qCourse.abbreviation.eq(abbrv);
//        final Flux all = this.courseRepository.findAll(eq);
//        return all;
        return null;
    }

    @Override
    public Mono getById(String id) {
        return this.courseRepository.findById(id);
    }

    @Override
    public Mono getByName(String name) {
        return null;
    }

    @Override
    public Flux getByLecturerName(String lecturerName) {
        return null;
    }
}
