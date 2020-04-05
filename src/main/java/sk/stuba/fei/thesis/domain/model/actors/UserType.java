package sk.stuba.fei.thesis.domain.model.actors;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets UserType
 */
public enum UserType {
  
  TEACHER("TEACHER"),
  
  STUDENT("STUDENT"),

  EXT("EXT");

  @ApiModelProperty(example = "TEACHER")
  private String value;

  UserType(@NotNull String value) {
    this.value = value;
  }
}

