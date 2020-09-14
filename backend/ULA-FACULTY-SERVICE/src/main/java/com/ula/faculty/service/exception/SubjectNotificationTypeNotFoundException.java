package com.ula.faculty.service.exception;

public class SubjectNotificationTypeNotFoundException extends Exception
{
    public SubjectNotificationTypeNotFoundException(String message)
    {
        super(message);
    }

    public SubjectNotificationTypeNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
