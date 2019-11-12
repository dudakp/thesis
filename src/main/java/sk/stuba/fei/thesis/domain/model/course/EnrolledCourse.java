package sk.stuba.fei.thesis.domain.model.course;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EnrolledCourse extends Course {

    private String parentCourseId;
    private String title;
    private String abbreviation;
    private Semester semester;
    private List<Exam> exams;
    private Exam finalExam;
    private List<Lab> labs;
    private List<Lecture> lectures;
}
