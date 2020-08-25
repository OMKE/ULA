package com.ula.authentication.service.auth;

import com.ula.authentication.domain.model.User;
import com.ula.authentication.service.exception.UserNotAuthorizedException;
import com.ula.authentication.service.exception.UserNotFoundException;
import org.ula.core.domain.model.ULAUserDTO;

import java.util.ArrayList;

public interface AuthService
{
    ULAUserDTO getUser(String username, ArrayList<String> roles);
    User verifyRoles(String username, ArrayList<String> roles) throws UserNotAuthorizedException, UserNotFoundException;
}
