package com.ula.content.util;

import com.ula.content.service.exception.FileStorageException;
import com.ula.content.service.exception.IllegalTypeOfFileException;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
public class FileValidator
{
    private List<String> contentTypes;
    // Size in MB
    private int size;

    public MultipartFile validate(MultipartFile file, String typeOfFile, int size) throws IllegalTypeOfFileException, FileStorageException
    {
        List<String> contentTypes = this.getMIMETypes(typeOfFile);
        if(contentTypes.contains(file.getContentType()))
        {
            if(this.validateFileSize(file, size)){
                return file;
            } else {
                throw new FileStorageException(String.format("File cant be bigger than %s MB", size));
            }
        } else {
            throw new FileStorageException(String.format("File is not valid of type: %s", contentTypes));
        }

    }

    public boolean validateFileSize(MultipartFile file, int size)
    {
        // multipy with 1024 so we transform provided size(which is in MB) to KB
        size = size * 1024;
        long fileSizeInBytes = file.getSize();
        long fileSizeInKB = fileSizeInBytes / 1024;

        if(fileSizeInKB > size)
        {
            return false;
        } else {
            return true;
        }
    }


    /*
        @param - typeOfFile - should be
        image - for image/png, image/jpeg
        pdf - for pdf files
        xml - for xml files
        zip - for zip files
     */

    public List<String> getMIMETypes(String typeOfFile) throws IllegalTypeOfFileException
    {
        switch (typeOfFile)
        {
            case "image":
                return this.getImageMIMETypes();
            case "pdf":
                return this.getPdfMIMETypes();
            case "json":
                return this.getJSONMIMETypes();
            case "xml":
                return this.getXMLMIMETypes();
            case "zip":
                return this.getZipMIMEType();
            default:
                throw new IllegalTypeOfFileException("Illegal type of file provided. Valid parameters are: image, pdf, json, xml, zip");
        }
    }

    public List<String> getImageMIMETypes()
    {
        return Arrays.asList("image/png", "image/jpeg");
    }

    public List<String> getPdfMIMETypes()
    {
        return Collections.singletonList("application/pdf");
    }

    public List<String> getJSONMIMETypes()
    {
        return Collections.singletonList("application/json");
    }

    public List<String> getXMLMIMETypes()
    {
        return Collections.singletonList("application/xml");
    }
    public List<String> getZipMIMEType()
    {
        return Collections.singletonList("application/zip");
    }
}
