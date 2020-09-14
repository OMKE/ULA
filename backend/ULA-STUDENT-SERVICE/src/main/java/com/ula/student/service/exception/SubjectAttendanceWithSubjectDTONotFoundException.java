package com.ula.student.service.exception;

public class SubjectAttendanceWithSubjectDTONotFoundException extends Exception
{
    public SubjectAttendanceWithSubjectDTONotFoundException(String message)
    {
        super(message);
    }

    public SubjectAttendanceWithSubjectDTONotFoundException(Throwable throwable)
    {
        super(throwable);
    }
}
