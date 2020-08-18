package com.ula.university.service.exception;

public class LocationNotFoundException extends Exception {

    public LocationNotFoundException(String message)
    {
        super(message);
    }
    public LocationNotFoundException(Throwable throwable)
    {
        super(throwable);
    }

}

