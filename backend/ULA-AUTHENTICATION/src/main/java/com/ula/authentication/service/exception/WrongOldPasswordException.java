package com.ula.authentication.service.exception;

public class WrongOldPasswordException extends Exception
{
    public WrongOldPasswordException(String message){ super(message); }
    public WrongOldPasswordException(Throwable throwable){ super(throwable); } 
    
}
