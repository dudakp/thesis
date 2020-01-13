package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import sk.stuba.fei.thesis.domain.model.actors.EmbeddedUser;
import sk.stuba.fei.thesis.domain.model.course.enums.Semester;

import javax.validation.Valid;
import java.util.List;


/**
 * EmbeddedCourse
 */
@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddedCourse {

    @JsonProperty("title")
    @ApiModelProperty(example = "Bachelors thesis 1")
    private String title = null;

    @JsonProperty("abrevaion")
    @ApiModelProperty(example = "BP1")
    private String abrevaion = null;

    @JsonProperty("semester")
    private Semester semester = null;

    @JsonProperty("lecturers")
    @Valid
    private List<EmbeddedUser> lecturers = null;

    @JsonProperty("instructors")
    @Valid
    private List<EmbeddedUser> instructors = null;

//    @JsonProperty("lectures")
//    @Valid
//    private List<Lecture> lectures = null;
//
//    @JsonProperty("labs")
//    @Valid
//    private List<Lecture> labs = null;
//
//    @JsonProperty("exams")
//    @Valid
//    private List<Exam> exams = null;
//
//    @JsonProperty("finals")
//    @Valid
//    private List<Exam> finals = null;
}

