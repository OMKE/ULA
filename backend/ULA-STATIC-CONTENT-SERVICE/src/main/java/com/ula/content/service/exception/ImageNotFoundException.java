package com.ula.content.service.exception;

public class ImageNotFoundException extends Exception
{
    public ImageNotFoundException(String message){ super(message); }
    public ImageNotFoundException(Throwable throwable){ super(throwable); } 
    
}
