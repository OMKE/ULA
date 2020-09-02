package com.ula.faculty.service.exception;

public class StudentNotFoundException extends Exception
{
    public StudentNotFoundException(String message)
    {
        super(message);
    }

    public StudentNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
