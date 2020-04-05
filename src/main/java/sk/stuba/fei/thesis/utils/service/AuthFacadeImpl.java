package sk.stuba.fei.thesis.utils.service;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import sk.stuba.fei.thesis.domain.dto.actor.UserDto;
import sk.stuba.fei.thesis.domain.model.actors.UserType;
import sk.stuba.fei.thesis.utils.api.AuthFacade;

import java.util.Map;

@Component
public class AuthFacadeImpl implements AuthFacade {

    @Override
    public String getIsName() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
    }

    @Override
    public String getUserType() {
        return (String) getUserAttributes().
                get("userType");
    }

    @Override
    public UserDto getAuthenticatedUser() {
        String[] userName = this.getUserToken()
                .getGivenName()
                .split(" ");
        Long isId = Long.parseLong((String) this.getUserAttributes().get("isId"));
        String isName = this.getIsName();
        String userType = this.getUserType().toUpperCase();
        return new UserDto(isId, isName, userName[0], userName[1], UserType.valueOf(userType));
    }

    private AccessToken getUserToken() {
        return ((KeycloakPrincipal) SecurityContextHolder.getContext().
                getAuthentication().
                getPrincipal()).
                getKeycloakSecurityContext()
                .getToken();
    }

    private Map<String, Object> getUserAttributes() {
        return getUserToken()
                .getOtherClaims();
    }
}
