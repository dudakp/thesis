package sk.stuba.fei.thesis.domain.model.course;


import com.querydsl.core.annotations.QueryEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import sk.stuba.fei.thesis.domain.dto.actor.UserDto;
import sk.stuba.fei.thesis.domain.model.course.enums.Semester;

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
    private List<UserDto> lecturers;
    private List<UserDto> instructors;

    private List<Exam> exams;
    private Exam finalExam;
    private List<Lecture> labs;
    private List<Lecture> lectures;

}
