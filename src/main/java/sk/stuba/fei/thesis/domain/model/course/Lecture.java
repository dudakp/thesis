package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import sk.stuba.fei.thesis.domain.model.course.enums.DayOfWeek;
import sk.stuba.fei.thesis.domain.model.course.enums.LectureType;

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
}

