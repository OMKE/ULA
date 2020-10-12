package com.ula.research.service.exception;

public class ResearchNotFoundException extends Exception
{
    public ResearchNotFoundException(String message)
    {
        super(message);
    }

    public ResearchNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
