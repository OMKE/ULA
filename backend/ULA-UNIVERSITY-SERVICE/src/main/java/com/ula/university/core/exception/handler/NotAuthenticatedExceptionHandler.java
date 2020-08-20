package com.ula.university.core.exception.handler;

import com.ula.university.core.exception.NotAuthorizedException;
import com.ula.university.dto.response.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotAuthenticatedExceptionHandler
{

    @ExceptionHandler(NotAuthorizedException.class)
    public Response<Object> handleNotAuthorizedException(NotAuthorizedException e)
    {
        return Response.unauthorized().setErrors(e.getMessage());
    }

}



