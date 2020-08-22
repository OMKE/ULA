package com.ula.university.service.exception;

public class PhoneNumberNotFoundException extends Exception
{
    public PhoneNumberNotFoundException(String message){ super(message); }
    public PhoneNumberNotFoundException(Throwable throwable){ super(throwable); } 
    
}
