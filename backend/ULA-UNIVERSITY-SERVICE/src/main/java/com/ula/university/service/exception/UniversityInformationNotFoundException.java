package com.ula.university.service.exception;


public class UniversityInformationNotFoundException extends Exception {

    public UniversityInformationNotFoundException(String message)
    {
        super(message);
    }
    public UniversityInformationNotFoundException(Throwable throwable)
    {
        super(throwable);
    }

}
