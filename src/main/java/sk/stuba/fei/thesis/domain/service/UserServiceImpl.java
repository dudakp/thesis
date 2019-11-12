package sk.stuba.fei.thesis.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sk.stuba.fei.thesis.domain.dao.UserRepository;
import sk.stuba.fei.thesis.domain.model.actors.Student;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.EnrolledCourse;

@Service
public class UserServiceImpl implements UserService {

    private final Logger loggerFactory = LoggerFactory.getLogger(this.getClass());


    private final UserRepository userRepository;
    private final CourseService courseService;

    public UserServiceImpl(UserRepository userRepository, CourseService courseService) {
        this.userRepository = userRepository;
        this.courseService = courseService;
    }

    public Flux<User> findAll() {
        return this.userRepository.findAll();
    }

    public Mono save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Mono getById(String userId) {
        return null;
    }

    @Override
    public Mono getByIsId(Long isId) {
        return null;
    }

    @Override
    public Flux getByName(String fullName) {
        return null;
    }

    @Override
    public Mono enrollToCourse(String courseId, String userIsID) {
        var enrollingStudent = this.userRepository.findById(userIsID);
        var courseToEnroll = this.courseService.getById(courseId);
        var enrolledCourse = courseToEnroll.flatMap((Course course) -> Mono.just(EnrolledCourse.builder()
                .parentCourseId(course.get_id())
                .title(course.getTitle())
                .abbreviation(course.getAbbreviation())
                .exams(course.getExams())
                .finalExam(course.getFinalExam())
                .labs(course.getLabs())
                .lectures(course.getLectures())
                .semester(course.getSemester())
                .build()));

        return enrollingStudent.flatMap(user -> enrolledCourse.flatMap(course -> {
                    ((Student) user).getEnrolledCourses().add(course);
                    return this.save(((User) user));
                })
        );
    }
}
