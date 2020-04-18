package sk.stuba.fei.thesis.events;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import sk.stuba.fei.thesis.domain.model.course.EducationalActivity;

@Component
public class MongoEventsHandler extends AbstractMongoEventListener<EducationalActivity> {
    @Override
    public void onBeforeConvert(BeforeConvertEvent<EducationalActivity> event) {
        System.out.println(event);
    }
}
