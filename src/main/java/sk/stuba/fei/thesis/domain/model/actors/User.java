package sk.stuba.fei.thesis.domain.model.actors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@QueryEntity
@Document(collection = "users")
public class User {

    @Id
    private String _id;

    @JsonProperty("isID")
    @ApiModelProperty(example = "92291")
    private Long isID;

    @JsonProperty("firstName")
    @ApiModelProperty(example = "Fero")
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("lastName")
    @ApiModelProperty(example = "Nefero")
    private String lastName;
}
