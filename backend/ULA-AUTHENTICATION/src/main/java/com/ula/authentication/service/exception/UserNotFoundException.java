package com.ula.authentication.service.exception;

public class UserNotFoundException extends Exception
{
    public UserNotFoundException(String message){ super(message); }
    public UserNotFoundException(Throwable throwable){ super(throwable); }

}
