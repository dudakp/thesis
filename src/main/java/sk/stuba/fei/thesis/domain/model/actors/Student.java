package sk.stuba.fei.thesis.domain.model.actors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import sk.stuba.fei.thesis.domain.model.course.Course;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Student extends User {

    private int credits;
    private List<Course> enrolledCourses = new ArrayList<>();

}

