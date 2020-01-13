package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Room
 */
@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @JsonProperty("room")
    @ApiModelProperty(example = "BC-300")
    private String room = null;
}

