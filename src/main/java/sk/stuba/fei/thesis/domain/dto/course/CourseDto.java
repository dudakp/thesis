package sk.stuba.fei.thesis.domain.dto.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import sk.stuba.fei.thesis.domain.dto.actor.UserDto;
import sk.stuba.fei.thesis.domain.model.course.EducationalActivity;
import sk.stuba.fei.thesis.domain.model.course.Exam;
import sk.stuba.fei.thesis.domain.model.course.Semester;

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
public class CourseDto {

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
    private List<UserDto> lecturers;

    @NotNull
    @JsonProperty("instructors")
    private List<UserDto> instructors;

    @JsonProperty("lectures")
    @Valid
    private List<EducationalActivity> educationalActivities = new ArrayList<>();

    @JsonProperty("labs")
    @Valid
    private List<EducationalActivity> labs = new ArrayList<>();

    @JsonProperty("exams")
    @Valid
    private List<Exam> exams = new ArrayList<>();

    @JsonProperty("finals")
    @Valid
    private List<Exam> finals = new ArrayList<>();

}


