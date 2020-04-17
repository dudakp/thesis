package sk.stuba.fei.thesis.persistence;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalTime;

public class KokotConverter implements Converter<LocalTime, String> {

    @Override
    public String convert(LocalTime s) {
        return s.toString();
    }
}
