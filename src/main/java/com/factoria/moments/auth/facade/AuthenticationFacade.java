package com.factoria.moments.auth.facade;
import com.factoria.moments.models.User;
import com.factoria.moments.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {
    @Autowired
    AuthRepository authRepository;

    public User getAuthUser() {
        var userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return authRepository.findByUsername(userName).get();
    }
}