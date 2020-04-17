package sk.stuba.fei.thesis.domain.model.course;


import com.querydsl.core.annotations.QueryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import sk.stuba.fei.thesis.domain.dto.actor.UserDto;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.domain.model.course.enums.Semester;

import javax.validation.constraints.NotNull;
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

    @NotNull
    @ApiModelProperty(example = "Operating systems")
    private String title;

    @NotNull
    @ApiModelProperty(example = "B-OS")
    private String abbreviation;

    @ApiModelProperty(required = false)
    private String description;

    @NotNull
    @ApiModelProperty(example = "WINTER", required = true)
    private Semester semester;

    @NotNull
    private List<EducationalActivity> lectures;

    // vytvori spring
    @NotNull
    @ApiModelProperty(required = true)
    private UserDto lecturer;

    // vytvori spring
    @NotNull
    @ApiModelProperty(required = true)
    private UserDto guarantor;

    private List<UserDto> instructors;

    private List<Exam> exams;
    private Exam finalExam;

    private List<EducationalActivity> labs;

    private String isCourseLink;

}
