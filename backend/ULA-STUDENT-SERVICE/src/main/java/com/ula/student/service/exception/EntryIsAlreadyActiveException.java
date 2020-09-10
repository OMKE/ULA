package com.ula.student.service.exception;

public class EntryIsAlreadyActiveException extends Exception
{
    public EntryIsAlreadyActiveException(String message)
    {
        super(message);
    }

    public EntryIsAlreadyActiveException(Throwable throwable)
    {
        super(throwable);
    }
}
