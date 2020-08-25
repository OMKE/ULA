package org.ula.core.auth;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.ula.core.annotation.Authorized;
import org.ula.core.domain.model.ULAUserDTO;
import org.ula.core.exception.JWTNotFoundException;
import org.ula.core.exception.NotAuthorizedException;
import org.ula.core.feign.AuthServiceFeignClient;
import org.ula.core.util.JWT;

import java.lang.reflect.Method;

@Aspect
@Component
public class Authentication
{

    @Autowired
    private AuthServiceFeignClient authServiceFeignClient;

    @Before("@annotation(org.ula.core.annotation.Authorized)")
    public void authenticate(JoinPoint joinPoint) throws NotAuthorizedException, JWTNotFoundException
    {
        JWT jwt = null;

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Authorized authorizedAnnotation = method.getAnnotation(Authorized.class);

        // Getting value from annotation, if there are many roles, they should be comma separated and in brackets
        String roles = authorizedAnnotation.value();



        for(Object o: joinPoint.getArgs())
        {
            // If o is instance of JWT, we know that we found correct parameter
            if(o instanceof JWT)
            {
                jwt = (JWT) o;
            }
        }
        // If there is token present, we will call the authentication service to check the token
        if(jwt != null)
        {
            // Auth-service has an util RoleResolver class which will create an array based on sent string
            // If user has correct roles, auth service will return an user object
            ULAUserDTO user = authServiceFeignClient.getUser(jwt.getContent(), roles);

            // If we didn't get the user object, that means that user is not authenticated so
            // we throw an exception which we can catch with global ControllerAdvice
            if (user == null)
            {
                throw new NotAuthorizedException("User is not authorized");
            } else {
//                user.getRoles().forEach(System.out::println);
            }
        } else {
            throw new JWTNotFoundException("@Authorized annotation can't be used without @Token parameter");
        }
    }


}
