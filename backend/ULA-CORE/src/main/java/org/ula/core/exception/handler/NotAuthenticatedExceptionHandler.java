package org.ula.core.exception.handler;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.ula.core.api.response.Response;
import org.ula.core.exception.NotAuthorizedException;


public class NotAuthenticatedExceptionHandler
{

    @ExceptionHandler(NotAuthorizedException.class)
    public Response<Object> handleNotAuthorizedException(NotAuthorizedException e)
    {
        return Response.unauthorized().setErrors(e.getMessage());
    }

}



