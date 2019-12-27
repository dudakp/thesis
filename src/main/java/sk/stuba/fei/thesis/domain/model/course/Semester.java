package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Gets or Sets Semester
 */
public enum Semester {
  
  WINTER("WINTER"),
  
  SPRING("SPRING");

  @ApiModelProperty(example = "WINTER")
  private String value;

  Semester(String value) {
    this.value = value;
  }
}

