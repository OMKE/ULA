package com.ula.exam.service.exception;

public class SubjectAttendanceConflictException extends Exception
{
    public SubjectAttendanceConflictException(String message)
    {
        super(message);
    }

    public SubjectAttendanceConflictException(Throwable throwable)
    {
        super(throwable);
    }
}
