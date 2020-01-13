package sk.stuba.fei.thesis.domain.model.course.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets Semester
 */
public enum Semester {
  
  WINTER("WINTER"),
  
  SPRING("SPRING");

  private String value;

  Semester(String value) {
    this.value = value;
  }
}

