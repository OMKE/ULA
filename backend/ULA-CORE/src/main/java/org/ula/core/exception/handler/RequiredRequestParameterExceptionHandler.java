package org.ula.core.exception.handler;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.ula.core.api.response.Response;

public class RequiredRequestParameterExceptionHandler
{

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Response<Object> handle(MissingServletRequestParameterException e)
    {
        return Response.badRequest().setErrors(e.getMessage());
    }
}
