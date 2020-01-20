package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import sk.stuba.fei.thesis.domain.model.actors.EmbeddedUser;
import sk.stuba.fei.thesis.domain.model.actors.User;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


/**
 * EmbeddedCourse
 */
@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddedCourse {

    @NotNull
    @JsonProperty("title")
    @ApiModelProperty(example = "Operating systems")
    private String title;

    @NotNull
    @JsonProperty("abrevaion")
    @ApiModelProperty(example = "B-OS")
    private String abbreviation;

    @NotNull
    @JsonProperty("semester")
    private Semester semester;

    @NotNull
    @JsonProperty("lecturers")
    private List<EmbeddedUser> lecturers;

    @NotNull
    @JsonProperty("instructors")
    private List<EmbeddedUser> instructors;

    @JsonProperty("lectures")
    @Valid
    private List<Lecture> lectures = new ArrayList<>();

    @JsonProperty("labs")
    @Valid
    private List<Lecture> labs = new ArrayList<>();

    @JsonProperty("exams")
    @Valid
    private List<Exam> exams = new ArrayList<>();

    @JsonProperty("finals")
    @Valid
    private List<Exam> finals = new ArrayList<>();

}


