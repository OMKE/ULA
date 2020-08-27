package com.ula.authentication.service.exception.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.ula.core.api.response.Response;

@RestControllerAdvice
public class AccessDeniedExceptionHandler
{

    @ExceptionHandler(AccessDeniedException.class)
    public Response<Object> handle(AccessDeniedException e)
    {
        return Response.accessDenied().setErrors(e.getMessage());
    }
}
