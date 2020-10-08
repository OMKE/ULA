package com.ula.authentication.service.exception;

public class UserIsAlreadyContentCreator extends Exception
{
    public UserIsAlreadyContentCreator(String message)
    {
        super(message);
    }

    public UserIsAlreadyContentCreator(Throwable throwable)
    {
        super(throwable);
    }
}
