package com.ula.faculty.service.exception;

public class StudyProgramDegreeNotFoundException extends Exception
{
    public StudyProgramDegreeNotFoundException(String message)
    {
        super(message);
    }

    public StudyProgramDegreeNotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
