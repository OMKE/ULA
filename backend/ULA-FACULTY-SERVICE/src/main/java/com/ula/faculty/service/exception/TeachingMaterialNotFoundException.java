package com.ula.faculty.service.exception;

public class TeachingMaterialNotFoundException extends Exception
{
    public TeachingMaterialNotFoundException(String message)
    {
        super(message);
    }

    public TeachingMaterialNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
