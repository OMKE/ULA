package com.ula.university.service.exception;


public class GalleryNotFoundException extends Exception {

    public GalleryNotFoundException(String message)
    {
        super(message);
    }
    public GalleryNotFoundException(Throwable throwable)
    {
        super(throwable);
    }

}
