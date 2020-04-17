package sk.stuba.fei.thesis.domain.model.course.enums;

public enum ActivityType {

    LAB("LAB"),
    LECTURE("LECTURE");

    private String value;

    ActivityType(String value) {
        this.value = value;
    }
}
