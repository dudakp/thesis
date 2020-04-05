package sk.stuba.fei.thesis.configuration;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.stuba.fei.thesis.domain.model.actors.QUser;

import java.util.Collections;

@Configuration
public class BeansConfiguration {

    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {
        DozerBeanMapper beanMapper = new DozerBeanMapper();
        beanMapper.setMappingFiles(Collections.singletonList("dozerJdk8Converters.xml"));
//        return new DozerBeanMapper();
        return beanMapper;
    }

    @Bean
    public QUser qUser() {
        return QUser.user;
    }

}
