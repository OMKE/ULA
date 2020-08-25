package org.ula.core.exception;

public class JWTNotFoundException extends Exception
{
    public JWTNotFoundException(String message){ super(message); }
    public JWTNotFoundException(Throwable throwable){ super(throwable); } 
    
}
