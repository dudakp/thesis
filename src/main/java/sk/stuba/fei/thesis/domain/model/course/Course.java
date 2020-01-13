package sk.stuba.fei.thesis.domain.model.course;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import sk.stuba.fei.thesis.domain.model.actors.EmbeddedUser;
import sk.stuba.fei.thesis.domain.model.course.enums.Semester;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "courses")
public class Course {
    @Id
    private String _id;
    private String title;
    private String abbreviation;
    private List<EmbeddedUser> enrolledStudents;
    private Semester semester;
    private List<EmbeddedUser> lecturers;
    private List<EmbeddedUser> instructors;
    private List<Exam> exams;
    private Exam finalExam;
    private List<Lecture> labs;
    private List<Lecture> lectures;
}
