package com.ula.authentication.service.exception;

public class UserNotAuthorizedException extends Exception
{
    public UserNotAuthorizedException(String message){ super(message); }
    public UserNotAuthorizedException(Throwable throwable){ super(throwable); } 
    
}
