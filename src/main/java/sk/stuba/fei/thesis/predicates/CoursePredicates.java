package sk.stuba.fei.thesis.predicates;

import com.querydsl.core.types.Predicate;
import sk.stuba.fei.thesis.domain.model.course.QCourse;

public final class CoursePredicates {
    private CoursePredicates() {
    }

    public static Predicate hasAbrv(String abrv) {
        return QCourse.course.abbreviation.equalsIgnoreCase(abrv);
    }

    public static Predicate hasTitleOrAbrv(String query) {
        return QCourse.course.title.containsIgnoreCase(query)
                .or(QCourse.course.abbreviation.containsIgnoreCase(query));
    }
}
