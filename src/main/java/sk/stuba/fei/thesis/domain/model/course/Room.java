package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

/**
 * Room
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@QueryEntity
@Document(collection = "rooms")
public class Room {
    @JsonProperty("room")
    @ApiModelProperty(example = "BC-300")
    private String room = null;
}

