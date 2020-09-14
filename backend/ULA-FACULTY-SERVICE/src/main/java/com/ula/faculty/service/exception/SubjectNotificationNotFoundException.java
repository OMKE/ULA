package com.ula.faculty.service.exception;

public class SubjectNotificationNotFoundException extends Exception
{
    public SubjectNotificationNotFoundException(String message)
    {
        super(message);
    }

    public SubjectNotificationNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
