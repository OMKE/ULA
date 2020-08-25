package com.ula.university.service.exception.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.ula.core.exception.handler.ValidExceptionHandler;

/*
    When @Valid throws an exception, this handler catches it
 */
@RestControllerAdvice
public class FieldExceptionHandler extends ValidExceptionHandler
{
}
