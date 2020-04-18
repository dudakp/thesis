package sk.stuba.fei.thesis.persistence;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import sk.stuba.fei.thesis.domain.model.course.EducationalActivity;

@ReadingConverter
public class LocalTimeReadingConverter implements Converter<EducationalActivity, EducationalActivity> {

    @Override
    public EducationalActivity convert(EducationalActivity s) {
        return new EducationalActivity(s.get_id(), s.getRoom(), s.getDayOfWeek(), s.getActivityType(), s.getForCourse(), s.getFrom(), s.getTo());
    }
}
