package com.ula.faculty.service.exception;

public class StudentOnYearConflictException extends Exception
{
    public StudentOnYearConflictException(String message)
    {
        super(message);
    }

    public StudentOnYearConflictException(Throwable throwable)
    {
        super(throwable);
    }
}
