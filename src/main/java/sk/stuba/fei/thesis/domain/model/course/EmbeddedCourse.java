package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;
import sk.stuba.fei.thesis.domain.model.actors.EmbeddedUser;
import sk.stuba.fei.thesis.domain.model.actors.Teacher;

import javax.validation.Valid;
import java.util.List;


/**
 * EmbeddedCourse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-23T17:12:16.081Z")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @JsonProperty("lectures")
    @Valid
    private List<EmbeddedUser> lectures = null;

    @JsonProperty("labs")
    @Valid
    private List<Lecture> labs = null;

    @JsonProperty("exams")
    @Valid
    private List<Exam> exams = null;

    @JsonProperty("finals")
    @Valid
    private List<Exam> finals = null;
}

