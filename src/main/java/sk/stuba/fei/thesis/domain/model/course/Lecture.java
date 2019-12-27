package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Lecture
 */
@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lecture {
    @JsonProperty("room")
    private Room room = null;

    @JsonProperty("dayOfWeek")
    @ApiModelProperty(example = "MONDAY")
    private DayOfWeek dayOfWeek;
}

