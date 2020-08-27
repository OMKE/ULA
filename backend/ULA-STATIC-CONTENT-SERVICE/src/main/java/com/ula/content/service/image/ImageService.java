package com.ula.content.service.image;

import com.ula.content.service.exception.FileStorageException;
import com.ula.content.service.exception.IllegalTypeOfFileException;
import com.ula.content.service.exception.ImageNotFoundException;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService
{
    String store(MultipartFile file, String folderName) throws FileStorageException, IllegalTypeOfFileException;
    byte[] load(String folderName, String fileName) throws ImageNotFoundException;
    String delete(String folderName,String fileName) throws FileStorageException;
    String delete(String path) throws FileStorageException;
}
