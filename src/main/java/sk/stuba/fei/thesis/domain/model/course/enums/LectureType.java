package sk.stuba.fei.thesis.domain.model.course.enums;

import lombok.Data;
import sk.stuba.fei.thesis.domain.model.course.Lecture;

public enum LectureType {

    LAB("LAB"),
    LECTURE("LECTURE");

    private String value;

    LectureType(String value) {
        this.value = value;
    }
}
