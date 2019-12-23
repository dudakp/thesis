package sk.stuba.fei.thesis.domain.model.course;

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

  @Override
  @JsonValue
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Semester fromValue(String text) {
    for (Semester b : Semester.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

