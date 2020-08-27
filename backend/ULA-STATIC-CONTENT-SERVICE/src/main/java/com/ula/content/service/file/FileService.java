package com.ula.content.service.file;

import com.ula.content.service.exception.FileStorageException;
import org.springframework.web.multipart.MultipartFile;

public interface FileService
{
    String getStoragePath();
    String store(String folderName, MultipartFile file) throws FileStorageException;
    String delete(String folderName, String fileName) throws FileStorageException;
    String delete(String path) throws FileStorageException;
    String replace(MultipartFile newFileName, String oldFileName);

    String separator();
}
