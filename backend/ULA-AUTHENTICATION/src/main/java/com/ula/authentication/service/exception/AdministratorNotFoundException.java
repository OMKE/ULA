package com.ula.authentication.service.exception;

public class AdministratorNotFoundException extends Exception
{
    public AdministratorNotFoundException(String message){ super(message); }
    public AdministratorNotFoundException(Throwable throwable){ super(throwable); }
    
}
