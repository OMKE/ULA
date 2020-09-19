package com.ula.teacher.service.exception;

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
