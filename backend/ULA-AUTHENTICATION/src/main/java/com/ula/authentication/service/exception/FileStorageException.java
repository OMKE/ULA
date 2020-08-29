package com.ula.authentication.service.exception;

public class FileStorageException extends Exception
{
    public FileStorageException(String message)
    {
        super(message);
    }

    public FileStorageException(Throwable throwable)
    {
        super(throwable);
    }
}
