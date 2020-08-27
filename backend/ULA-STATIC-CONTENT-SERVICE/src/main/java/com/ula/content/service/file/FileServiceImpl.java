package com.ula.content.service.file;

import com.ula.content.service.exception.FileStorageException;
import com.ula.content.util.StorageUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

@Service
public class FileServiceImpl implements FileService
{

    @Autowired
    private StorageUtil storageUtil;

    public String getStoragePath()
    {
        return this.storageUtil.getContentPath().replace("/", this.separator());
    }

    @Override
    public String store(String folderName, MultipartFile file) throws FileStorageException
    {
        List<String> folders = Arrays.asList(storageUtil.getFolders());
        if (!folders.contains(folderName))
        {
            throw new IllegalArgumentException(String.format("Folder with name %s can not be found", folderName));
        }

        // Get file extension
        String fileExtension = "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        // Remove extension from original file name
        String fileName = file.getOriginalFilename().replace(fileExtension, "");
        // Concat everything together while appending current time millis
        fileName = fileName.toLowerCase().replaceAll(" ", "-") + "_" + System.currentTimeMillis() + fileExtension;

        try {
            if(file.isEmpty())
            {
                throw new FileStorageException(String.format("File: %s is empty", file.getOriginalFilename()));
            }
            if(fileName.contains(".."))
            {
                throw new FileStorageException(String.format("File: %s violates security policy", fileName));
            }
            Path copyLocation = Paths
                    .get(this.getStoragePath() + folderName + this.separator());

            Files.copy(file.getInputStream(), copyLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException e)
        {
            throw new FileStorageException(String.format("File: %s could not be stored.", file.getOriginalFilename()));
        }
    }

    @Override
    public String delete(String folderName, String fileName) throws FileStorageException
    {
        File file = FileUtils.getFile(this.getStoragePath() + folderName + this.separator() + fileName);
        boolean success = FileUtils.deleteQuietly(file);
        if(success)
        {
            return String.format("File %s has been deleted");
        } else {
            throw new FileStorageException("There was an exception deleting %s file");
        }
    }

    @Override
    public String delete(String path) throws FileStorageException
    {
        File file = FileUtils.getFile(this.getStoragePath() + path);
        boolean success = FileUtils.deleteQuietly(file);
        if(success)
        {
            return String.format("File %s has been deleted", path.substring(path.lastIndexOf("/") + 1));
        } else {
            throw new FileStorageException(String.format("There was an exception deleting %s file", path.substring(path.lastIndexOf("/") + 1)));
        }
    }

    @Override
    public String replace(MultipartFile newFileName, String oldFileName)
    {
        return null;
    }

    public final String separator()
    {
        return File.separator;
    }
}
