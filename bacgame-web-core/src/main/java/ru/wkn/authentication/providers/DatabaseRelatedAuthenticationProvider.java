package ru.wkn.authentication.providers;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import ru.wkn.RepositoryFacade;
import ru.wkn.entities.Gamer;
import ru.wkn.services.GamerService;

import java.util.ArrayList;

public class DatabaseRelatedAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();
        RepositoryFacade repositoryFacade = new RepositoryFacade("gamerService");
        Gamer gamer = ((GamerService) repositoryFacade.getService()).authenticate(login, password);
        if (gamer != null) {
            return new UsernamePasswordAuthenticationToken(login, password, new ArrayList<>());
        }
        throw new BadCredentialsException("login or password is invalid");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
