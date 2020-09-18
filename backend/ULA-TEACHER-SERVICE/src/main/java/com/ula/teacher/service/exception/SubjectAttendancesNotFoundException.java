package com.ula.teacher.service.exception;

public class SubjectAttendancesNotFoundException extends Exception
{
    public SubjectAttendancesNotFoundException(String message)
    {
        super(message);
    }

    public SubjectAttendancesNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
