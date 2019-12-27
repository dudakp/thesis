package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import sk.stuba.fei.thesis.domain.model.actors.EmbeddedUser;

import javax.validation.Valid;
import java.util.List;


/**
 * EmbeddedCourse
 */
@Validated
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmbeddedCourse {

    @JsonProperty("title")
    @ApiModelProperty(example = "Bachelors thesis 1")
    private String title;

    @JsonProperty("abrevaion")
    @ApiModelProperty(example = "BP1")
    private String abbreviation;

    @JsonProperty("semester")
    private Semester semester;

    @JsonProperty("lecturers")
    @Valid
    private List<EmbeddedUser> lecturers;

    @JsonProperty("instructors")
    @Valid
    private List<EmbeddedUser> instructors;

    @JsonProperty("lectures")
    @Valid
    private List<Lecture> lectures;

    @JsonProperty("labs")
    @Valid
    private List<Lecture> labs;

    @JsonProperty("exams")
    @Valid
    private List<Exam> exams;

    @JsonProperty("finals")
    @Valid
    private Exam finals;
}

