package sk.stuba.fei.thesis.domain.model.actors.enums;

import lombok.RequiredArgsConstructor;

public enum UserType {

    MONDAY("MONDAY"),
    TUESDAY("TUESDAY");
    
    private String value;

    UserType(String value) {
        this.value = value;
    }
}
