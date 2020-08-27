package com.ula.authentication.service.exception;

public class UserIsAlreadyAdministratorException extends Exception
{
    public UserIsAlreadyAdministratorException(String message){ super(message); }
    public UserIsAlreadyAdministratorException(Throwable throwable){ super(throwable); } 
    
}
