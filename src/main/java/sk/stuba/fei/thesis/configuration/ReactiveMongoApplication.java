package sk.stuba.fei.thesis.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import sk.stuba.fei.thesis.persistence.LocalTimeConverter;

import java.util.ArrayList;
import java.util.List;

@EnableReactiveMongoRepositories
public class ReactiveMongoApplication extends AbstractReactiveMongoConfiguration {

    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return "thesis";
    }

    @Override
    public MongoCustomConversions customConversions() {
        converters.add(new LocalTimeConverter());
        return new MongoCustomConversions(converters);
    }
}
