package com.ula.authentication.domain.guard;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class StudentGuard
{
    public static boolean check(String username, Authentication authentication)
    {
        return username.equals(authentication.getName());
    }
}
