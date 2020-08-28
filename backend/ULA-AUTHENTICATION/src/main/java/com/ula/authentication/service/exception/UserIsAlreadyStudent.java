package com.ula.authentication.service.exception;

public class UserIsAlreadyStudent extends Exception
{
    public UserIsAlreadyStudent(String message){ super(message); }
    public UserIsAlreadyStudent(Throwable throwable){ super(throwable); } 
    
}
