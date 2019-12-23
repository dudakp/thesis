package sk.stuba.fei.thesis.domain.model.course;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Room
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-23T17:12:16.081Z")

public class Room   {
  @JsonProperty("room")
  private String room = null;

  public Room room(String room) {
    this.room = room;
    return this;
  }

  /**
   * Get room
   * @return room
  **/
  @ApiModelProperty(value = "")


  public String getRoom() {
    return room;
  }

  public void setRoom(String room) {
    this.room = room;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Room room = (Room) o;
    return Objects.equals(this.room, room.room);
  }

  @Override
  public int hashCode() {
    return Objects.hash(room);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Room {\n");
    
    sb.append("    room: ").append(toIndentedString(room)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

