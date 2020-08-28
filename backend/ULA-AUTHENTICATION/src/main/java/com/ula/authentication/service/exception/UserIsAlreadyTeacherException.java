package com.ula.authentication.service.exception;

public class UserIsAlreadyTeacherException extends Exception
{
    public UserIsAlreadyTeacherException(String message)
    {
        super(message);
    }

    public UserIsAlreadyTeacherException(Throwable throwable)
    {
        super(throwable);
    }
}
