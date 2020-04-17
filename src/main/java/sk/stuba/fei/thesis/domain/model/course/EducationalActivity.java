package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import sk.stuba.fei.thesis.domain.model.course.enums.ActivityType;
import sk.stuba.fei.thesis.domain.model.course.enums.DayOfWeek;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

/**
 * Lecture
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@QueryEntity
@Document(collection = "educationalActivities")
public class EducationalActivity {

    @Id
    private String _id;

    @JsonProperty("room")
    private String room;

    @NotNull
    @JsonProperty("dayOfWeek")
    @ApiModelProperty(example = "MONDAY")
    private DayOfWeek dayOfWeek;

    @NotNull
    @JsonProperty("activityType")
    @ApiModelProperty(example = "LECTURE")
    private ActivityType activityType;

    @NotNull
    @JsonProperty("forCourse")
    @ApiModelProperty(example = "B-OS")
    private String forCourse;

    @NotNull
    @JsonProperty("from")
    private LocalTime from;

    @NotBlank
    @JsonProperty("to")
    private LocalTime to;
}

