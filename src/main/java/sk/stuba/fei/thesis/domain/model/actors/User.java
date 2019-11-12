package sk.stuba.fei.thesis.domain.model.actors;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "users")
public class User {

    @Id
    private String _id;
    private Long isID;
    private String firstName;
    private String middleName;
    private String lastName;
}
