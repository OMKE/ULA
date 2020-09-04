package com.ula.exam.service.exception;

public class ExamOutcomeNotFoundException extends Exception
{
    public ExamOutcomeNotFoundException(String message)
    {
        super(message);
    }

    public ExamOutcomeNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
