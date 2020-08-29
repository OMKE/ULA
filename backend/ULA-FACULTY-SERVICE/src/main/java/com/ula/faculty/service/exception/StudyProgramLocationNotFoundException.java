package com.ula.faculty.service.exception;

public class StudyProgramLocationNotFoundException extends Exception
{
    public StudyProgramLocationNotFoundException(String message)
    {
        super(message);
    }

    public StudyProgramLocationNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
