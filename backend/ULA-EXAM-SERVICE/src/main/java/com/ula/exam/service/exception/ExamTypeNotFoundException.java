package com.ula.exam.service.exception;

public class ExamTypeNotFoundException extends Exception
{
    public ExamTypeNotFoundException(String message)
    {
        super(message);
    }

    public ExamTypeNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
