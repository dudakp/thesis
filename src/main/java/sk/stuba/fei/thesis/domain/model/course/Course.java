package sk.stuba.fei.thesis.domain.model.course;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import sk.stuba.fei.thesis.domain.model.actors.EmbeddedUser;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "courses")
public class Course {

    @Id
    private String _id;
    private String title;
    private String abbreviation;
    private List<EmbeddedUser> enrolledStudents;
    private Semester semester;
    private EmbeddedUser lecturer;
    private List<EmbeddedUser> instructors;
    private List<Exam> exams;
    private Exam finalExam;
    private List<Lab> labs;
    private List<Lecture> lectures;


}
