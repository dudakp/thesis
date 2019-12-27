package sk.stuba.fei.thesis.domain.model.actors;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddedUser {
    @JsonProperty("isID")
    @ApiModelProperty(example = "90010")
    private Integer isID = null;

    @JsonProperty("firstName")
    @ApiModelProperty(example = "Fero")
    private String firstName = null;

    @JsonProperty("lastName")
    @ApiModelProperty(example = "Policka")
    private String lastName = null;

    @JsonProperty("userType")
    private UserType userType = null;
}
