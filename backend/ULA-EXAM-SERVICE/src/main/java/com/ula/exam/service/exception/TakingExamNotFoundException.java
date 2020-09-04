package com.ula.exam.service.exception;

public class TakingExamNotFoundException extends Exception
{
    public TakingExamNotFoundException(String message)
    {
        super(message);
    }

    public TakingExamNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
