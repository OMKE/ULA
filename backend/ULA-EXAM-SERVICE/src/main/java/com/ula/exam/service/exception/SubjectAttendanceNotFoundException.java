package com.ula.exam.service.exception;

public class SubjectAttendanceNotFoundException extends Exception
{
    public SubjectAttendanceNotFoundException(String message)
    {
        super(message);
    }

    public SubjectAttendanceNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
