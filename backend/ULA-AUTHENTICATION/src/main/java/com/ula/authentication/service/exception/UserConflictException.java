package com.ula.authentication.service.exception;

public class UserConflictException extends Exception
{
    public UserConflictException(String message){ super(message); }
    public UserConflictException(Throwable throwable){ super(throwable); } 
    
}
