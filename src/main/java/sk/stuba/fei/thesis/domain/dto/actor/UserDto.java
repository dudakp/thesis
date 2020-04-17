package sk.stuba.fei.thesis.domain.dto.actor;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.thesis.domain.model.actors.UserType;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotNull
    @JsonProperty("isID")
    @ApiModelProperty(example = "90010")
    private Long isID;

    @JsonProperty("isName")
    @ApiModelProperty(example = "xmrkvickaf")
    private String isName;

    @JsonProperty("firstName")
    @ApiModelProperty(example = "Fero")
    private String firstName;

    @JsonProperty("lastName")
    @ApiModelProperty(example = "Mrkvicka")
    private String lastName;

    @JsonProperty("userType")
    private UserType userType;
}
