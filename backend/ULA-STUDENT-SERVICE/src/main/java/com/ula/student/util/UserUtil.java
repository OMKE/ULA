package com.ula.student.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ula.core.util.JWT;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserUtil
{

    @Autowired
    private HttpServletRequest request;

    public String getUsername()
    {
        JWT jwt = new JWT(request.getHeader("Authorization"));

        return jwt.getUsername();
    }
}
