package com.ula.authentication.service.exception;

public class StudentSSNConflictException extends Exception
{
    public StudentSSNConflictException(String message)
    {
        super(message);
    }

    public StudentSSNConflictException(Throwable throwable)
    {
        super(throwable);
    }
}
