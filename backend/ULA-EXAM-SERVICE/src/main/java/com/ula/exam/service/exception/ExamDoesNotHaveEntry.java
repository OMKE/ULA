package com.ula.exam.service.exception;

public class ExamDoesNotHaveEntry extends Exception
{
    public ExamDoesNotHaveEntry(String message)
    {
        super(message);
    }

    public ExamDoesNotHaveEntry(Throwable throwable)
    {
        super(throwable);
    }
}
