package com.ula.university.service.exception;


public class UniversityNotFoundException extends Exception {

    public UniversityNotFoundException(String message)
    {
        super(message);
    }
    public UniversityNotFoundException(Throwable throwable)
    {
        super(throwable);
    }

}
