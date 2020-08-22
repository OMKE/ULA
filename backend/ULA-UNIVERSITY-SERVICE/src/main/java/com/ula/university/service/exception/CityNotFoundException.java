package com.ula.university.service.exception;

public class CityNotFoundException extends Exception
{
    public CityNotFoundException(String message){ super(message); }
    public CityNotFoundException(Throwable throwable){ super(throwable); } 
    
}
