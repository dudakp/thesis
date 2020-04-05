package sk.stuba.fei.thesis.predicates;

import com.querydsl.core.types.dsl.ListPath;
import sk.stuba.fei.thesis.domain.model.actors.QUser;
import sk.stuba.fei.thesis.domain.model.course.Course;
import sk.stuba.fei.thesis.domain.model.course.QCourse;

public final class CoursePredicates {
    private CoursePredicates() {}

    public static ListPath<Course, QCourse> enrolledCourses() {
        return QUser.user.enrolledCourses;
    }
}
