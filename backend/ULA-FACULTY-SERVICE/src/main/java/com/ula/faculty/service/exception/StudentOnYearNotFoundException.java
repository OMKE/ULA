package com.ula.faculty.service.exception;

public class StudentOnYearNotFoundException extends Exception
{
    public StudentOnYearNotFoundException(String message)
    {
        super(message);
    }

    public StudentOnYearNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
