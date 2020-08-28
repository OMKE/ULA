package org.ula.core.exception.handler;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.ula.core.api.response.Response;

import java.util.ArrayList;

public class MethodArgumentNotValidExceptionHandler
{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<Object> handle(MethodArgumentNotValidException e)
    {
        return Response.validationException().setErrors(this.getMessages(e.getMessage()));
    }


    private ArrayList<String> getMessages(String exceptionMessage)
    {
        ArrayList<String> messages = new ArrayList<>();
        for(String str: exceptionMessage.split(","))
        {
            messages.add(str.split(":")[1].trim() + ".");
        }
        return messages;
    }
}
