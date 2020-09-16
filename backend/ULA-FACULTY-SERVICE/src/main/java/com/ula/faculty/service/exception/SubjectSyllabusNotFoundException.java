package com.ula.faculty.service.exception;

public class SubjectSyllabusNotFoundException extends Exception
{
    public SubjectSyllabusNotFoundException(String message)
    {
        super(message);
    }

    public SubjectSyllabusNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
