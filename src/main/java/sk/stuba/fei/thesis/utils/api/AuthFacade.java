package sk.stuba.fei.thesis.utils.api;

import sk.stuba.fei.thesis.domain.dto.actor.UserDto;

public interface AuthFacade {

    String getUserType();

    String getIsName();

    UserDto getAuthenticatedUser();
}
