package com.ula.faculty.service.exception;

public class StudyProgramNotFoundException extends Exception
{
    public StudyProgramNotFoundException(String message) { super(message); }
    public StudyProgramNotFoundException(Throwable throwable) { super(throwable); }
}
