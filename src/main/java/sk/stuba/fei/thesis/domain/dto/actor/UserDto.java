package sk.stuba.fei.thesis.domain.dto.actor;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.thesis.domain.model.actors.UserType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @JsonProperty("isID")
    @ApiModelProperty(example = "90010")
    private Long isID = null;

    @JsonProperty("isName")
    @ApiModelProperty(example = "xmrkvickaf")
    private String isName;

    @JsonProperty("firstName")
    @ApiModelProperty(example = "Fero")
    private String firstName = null;

    @JsonProperty("lastName")
    @ApiModelProperty(example = "Policka")
    private String lastName = null;

    @JsonProperty("userType")
    private UserType userType = null;
}
