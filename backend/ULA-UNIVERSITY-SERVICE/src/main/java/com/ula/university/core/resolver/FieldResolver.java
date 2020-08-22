package com.ula.university.core.resolver;

import com.ula.university.dto.response.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;

@RestControllerAdvice
public class FieldResolver
{
    @ExceptionHandler(ConstraintViolationException.class)
    public Response<Object> handle(ConstraintViolationException e)
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
