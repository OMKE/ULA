package com.ula.exam.service.exception;

public class ExamDoesNotHaveActiveEntryException extends Exception
{
    public ExamDoesNotHaveActiveEntryException(String message)
    {
        super(message);
    }

    public ExamDoesNotHaveActiveEntryException(Throwable throwable)
    {
        super(throwable);
    }
}
