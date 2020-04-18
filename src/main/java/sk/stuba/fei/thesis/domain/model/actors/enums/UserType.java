package sk.stuba.fei.thesis.domain.model.actors.enums;

import lombok.RequiredArgsConstructor;

public enum UserType {

    ADMIN("ADMIN"),
    STUDENT("STUDENT"),
    TEACHER("TEACHER");

    private String value;

    UserType(String value) {
        this.value = value;
    }
}
