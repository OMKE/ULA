package com.ula.student.service.exception;

public class ExamNotFoundException extends Exception
{
    public ExamNotFoundException(String message)
    {
        super(message);
    }

    public ExamNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
