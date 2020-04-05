package sk.stuba.fei.thesis.domain.model.actors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.querydsl.core.annotations.QueryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;
import sk.stuba.fei.thesis.domain.model.course.Course;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
//@RequiredArgsConstructor
@Getter
@Setter
@QueryEntity
@Document(collection = "users")
public class User {

    @Id
    private String _id;

    @NotNull
    @JsonProperty("isID")
    @ApiModelProperty(example = "82375")
    private Long isID;

    @NotNull
    @JsonProperty("isName")
    private String isName;

    @NotNull
    @JsonProperty("firstName")
    @ApiModelProperty(example = "Andrej")
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @NotNull
    @JsonProperty("lastName")
    @ApiModelProperty(example = "Drobny")
    private String lastName;

    @NotNull
    @JsonProperty("userType")
    private UserType userType;

    @JsonProperty("enrolledCourses")
    private List<Course> enrolledCourses = new ArrayList<>();

    public User(Long i, String xdudakp, String pavol, String dudak, UserType student) {
        this.isID = i;
        this.isName = xdudakp;
        this.firstName = pavol;
        this.lastName = dudak;
        this.userType = student;
    }
}
