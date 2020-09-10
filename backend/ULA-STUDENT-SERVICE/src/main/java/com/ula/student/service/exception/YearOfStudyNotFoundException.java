package com.ula.student.service.exception;

public class YearOfStudyNotFoundException extends Exception
{
    public YearOfStudyNotFoundException(String message)
    {
        super(message);
    }

    public YearOfStudyNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
