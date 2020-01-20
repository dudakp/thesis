package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.internal.connection.Time;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import sk.stuba.fei.thesis.domain.model.course.enums.DayOfWeek;
import sk.stuba.fei.thesis.domain.model.course.enums.LectureType;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * Lecture
 */
@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "lectures")
public class Lecture {

    @Id
    private String _id;

    @JsonProperty("room")
    private Room room = null;

    @JsonProperty("dayOfWeek")
    @ApiModelProperty(example = "MONDAY")
    private DayOfWeek dayOfWeek;

    @JsonProperty("lectureType")
    @ApiModelProperty(example = "LECTURE")
    private LectureType lectureType;

    @JsonProperty("forCourse")
    @ApiModelProperty(example = "B-OS")
    private String forCourse;

    @JsonProperty("from")
    @ApiModelProperty(example = "08:00")
    private String from;

    @JsonProperty("to")
    @ApiModelProperty(example = "09:40")
    private String to;
}

