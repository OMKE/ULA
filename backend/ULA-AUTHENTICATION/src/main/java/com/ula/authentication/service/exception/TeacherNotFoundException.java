package com.ula.authentication.service.exception;

public class TeacherNotFoundException extends Exception
{
    public TeacherNotFoundException(String message)
    {
        super(message);
    }

    public TeacherNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
