package com.ula.authentication.service.user;

import com.ula.authentication.dto.model.ULAUserDTO;

public interface AuthService
{
    ULAUserDTO authorize(String token);
}
