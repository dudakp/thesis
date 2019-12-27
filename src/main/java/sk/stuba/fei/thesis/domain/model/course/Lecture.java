package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.aggregation.DateOperators;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

/**
 * Lecture
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-23T17:12:16.081Z")

public class Lecture {
    @JsonProperty("room")
    private Room room = null;

    @JsonProperty("dayOfWeek")
    @ApiModelProperty(example = "1")
    private DateOperators.DayOfWeek dayOfWeek = null;
}

