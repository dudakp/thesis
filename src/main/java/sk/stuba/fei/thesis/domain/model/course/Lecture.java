package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("date")
    private LocalDate date = null;
}

