package com.ula.faculty.service.exception;

public class SubjectNotFoundException extends Exception
{
    public SubjectNotFoundException(String message) { super(message); }
    public SubjectNotFoundException(Throwable throwable) { super(throwable); }
}
