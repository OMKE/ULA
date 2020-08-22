package com.ula.university.service.exception;

public class AddressNotFoundException extends Exception
{
    public AddressNotFoundException(String message){ super(message); }
    public AddressNotFoundException(Throwable throwable){ super(throwable); } 
    
}
