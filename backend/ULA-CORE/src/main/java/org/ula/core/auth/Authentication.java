package org.ula.core.auth;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Component;
import org.ula.core.annotation.Authorized;
import org.ula.core.domain.model.ULAUserDTO;
import org.ula.core.exception.NotAuthorizedException;
import org.ula.core.feign.AuthServiceFeignClient;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@EnableFeignClients("org.ula.core.feign")
@Component
public class Authentication
{

    private static Logger LOGGER = LoggerFactory.getLogger(Authentication.class);

    @Autowired
    private AuthServiceFeignClient authServiceFeignClient;

    @Autowired
    private HttpServletRequest request;

    @Before("@annotation(org.ula.core.annotation.Authorized)")
    public void authenticate(JoinPoint joinPoint) throws NotAuthorizedException
    {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Authorized authorizedAnnotation = method.getAnnotation(Authorized.class);

        // Getting value from annotation, if there are many roles, they should be comma separated and in brackets
        String roles = authorizedAnnotation.value();

        String token = this.request.getHeader("Authorization");

        if(this.checkHeader(token))
        {
            ULAUserDTO user = authServiceFeignClient.getUser(token, roles);

            // If we didn't get the user object, that means that user is not authenticated so
            // we throw an exception which we can catch with global ControllerAdvice
            if (user == null)
            {
                LOGGER.error("User is not authorized because AuthService returned null");
                throw new NotAuthorizedException("User is not authorized");
            }
        } else {
            LOGGER.error("Missing Authorization header");
            throw new NotAuthorizedException("User is not authorized");
        }


    }


    private boolean checkHeader(String header)
    {
        if(header != null && !header.equals(""))
        {
            return true;
        } else {
            return false;
        }
    }


}
