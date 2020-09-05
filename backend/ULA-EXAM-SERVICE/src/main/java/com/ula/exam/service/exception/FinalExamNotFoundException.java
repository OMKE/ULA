package com.ula.exam.service.exception;

public class FinalExamNotFoundException extends Exception
{
    public FinalExamNotFoundException(String message)
    {
        super(message);
    }

    public FinalExamNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
