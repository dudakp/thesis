package sk.stuba.fei.thesis.domain.model.course.enums;

public enum DayOfWeek {

    MONDAY("MONDAY"),
    TUESDAY("TUESDAY"),
    WEDNESDAY("WEDNESDAY"),
    THURSDAY("THURSDAY"),
    FRIDAY("FRIDAY");

    private String value;

    DayOfWeek(String value) {
        this.value = value;
    }
}
