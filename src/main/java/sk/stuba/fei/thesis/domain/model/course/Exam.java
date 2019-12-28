package sk.stuba.fei.thesis.domain.model.course;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;

/**
 * Exam
 */
@Validated
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "exams")
public class Exam {

    @Id
    private String _id;

    @JsonProperty("date")
    @ApiModelProperty(example = "2020-01-01")
    private LocalDate date;

    @JsonProperty("room")
    @ApiModelProperty(example = "BC-300")
    private Room room;
}
