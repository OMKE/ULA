package com.ula.faculty.service.exception;

public class FifteenDaysPassedAfterEndOfExamTermException extends Exception
{
    public FifteenDaysPassedAfterEndOfExamTermException(String message)
    {
        super(message);
    }

    public FifteenDaysPassedAfterEndOfExamTermException(Throwable throwable)
    {
        super(throwable);
    }
}
