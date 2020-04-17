package sk.stuba.fei.thesis.persistence;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;

public class LocalTimeReadingConverter implements Converter<String, LocalTime> {

    @Override
    public LocalTime convert(String s) {
        return LocalTime.parse(s);
    }
}
