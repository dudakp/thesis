package sk.stuba.fei.thesis.domain.model.actors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import sk.stuba.fei.thesis.domain.model.course.Course;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class Teacher extends User {

    public List<Course> teachingCourses;

}
