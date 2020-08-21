package com.ula.faculty.service.exception;


public class FacultyNotFoundException extends Exception {

    public FacultyNotFoundException(String message)
    {
        super(message);
    }
    public FacultyNotFoundException(Throwable throwable)
    {
        super(throwable);
    }

}
