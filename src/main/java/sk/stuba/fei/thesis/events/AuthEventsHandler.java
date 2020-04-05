package sk.stuba.fei.thesis.events;

import lombok.AllArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import sk.stuba.fei.thesis.dao.api.UserSearchService;
import sk.stuba.fei.thesis.domain.dao.UserRepository;
import sk.stuba.fei.thesis.domain.model.actors.User;
import sk.stuba.fei.thesis.utils.api.AuthFacade;

@Component
@AllArgsConstructor
public class AuthEventsHandler implements ApplicationListener<ApplicationEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthEventsHandler.class);

    private final AuthFacade authFacade;
    private final UserRepository userRepository;
    private final UserSearchService userSearchService;

    private final DozerBeanMapper mapper;


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof AuthenticationSuccessEvent) {
            this.userSearchService.findByIsName(this.authFacade.getIsName())
                    .switchIfEmpty(this.userRepository.save(
                            this.mapper.map(this.authFacade.getAuthenticatedUser(), User.class)))
                    .subscribe(
                            user -> this.LOGGER.debug(user.toString())
                    );
        }
    }
}
