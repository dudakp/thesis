package sk.stuba.fei.thesis.domain.model.actors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@QueryEntity
@Document(collection = "users")
public class User {

    @Id
    private String _id;

    @NotNull
    @JsonProperty("isID")
    @ApiModelProperty(example = "82375")
    private Long isID;

    @NotNull
    @JsonProperty("firstName")
    @ApiModelProperty(example = "Andrej")
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @NotNull
    @JsonProperty("lastName")
    @ApiModelProperty(example = "Drobny")
    private String lastName;

    @NotNull
    @JsonProperty("userType")
    private UserType userType;
}
