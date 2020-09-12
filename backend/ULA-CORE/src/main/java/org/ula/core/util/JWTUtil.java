package org.ula.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class JWTUtil
{
    @Autowired
    private HttpServletRequest request;

    private static final String HEADER_NAME = "Authorization";

    public String getUsername()
    {
        JWT jwt = new JWT(request.getHeader(HEADER_NAME));

        return jwt.getUsername();
    }

    public String getToken()
    {
        return this.request.getHeader(HEADER_NAME);
    }

}
