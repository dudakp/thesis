package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDate;

/**
 * Exam
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-12-23T17:12:16.081Z")

public class Exam {
    @JsonProperty("date")
    private LocalDate date = null;

    @JsonProperty("room")
    private Room room = null;

    public Exam date(LocalDate date) {
        this.date = date;
        return this;
    }

    /**
     * Get date
     *
     * @return date
     **/
    @ApiModelProperty(value = "")

    @Valid

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Exam room(Room room) {
        this.room = room;
        return this;
    }

    /**
     * Get room
     *
     * @return room
     **/
    @ApiModelProperty(value = "")

    @Valid

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
