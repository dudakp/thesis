package sk.stuba.fei.thesis.domain.model.course;


import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import sk.stuba.fei.thesis.domain.model.actors.EmbeddedUser;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@QueryEntity
@Document(collection = "courses")
public class Course {
    @Id
    private String _id;
    private String title;
    private String abbreviation;
    private Semester semester;
    private List<EmbeddedUser> lecturers;
    private List<EmbeddedUser> instructors;
    private List<Lecture> lectures;
    private List<Lecture> labs;
    private List<Exam> exams;
    private Exam finals;

    private List<EmbeddedUser> enrolledStudents;


}
