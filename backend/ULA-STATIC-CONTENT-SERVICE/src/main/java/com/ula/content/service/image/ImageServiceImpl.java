package com.ula.content.service.image;

import com.ula.content.service.exception.FileStorageException;
import com.ula.content.service.exception.IllegalTypeOfFileException;
import com.ula.content.service.exception.ImageNotFoundException;
import com.ula.content.service.file.FileService;
import com.ula.content.util.FileValidator;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class ImageServiceImpl implements ImageService
{
    @Autowired
    private FileService fileService;


    @Override
    public String store(MultipartFile file, String folderName) throws IllegalTypeOfFileException, FileStorageException
    {
        FileValidator fileValidator = new FileValidator();
        return this.fileService.store(folderName, fileValidator.validate(file, "image", 2));
    }

    @Override
    public byte[] load(String folderName, String fileName) throws ImageNotFoundException
    {
        try {
            InputStream inputStream = new BufferedInputStream
                    (
                            new FileInputStream
                                    (
                                            this.fileService.getStoragePath() + folderName + fileService.separator() + fileName
                                    )
                    );
            try {
                return IOUtils.toByteArray(inputStream);
            } catch (IOException e) {
                throw new ImageNotFoundException("Image could not be found");
            }
        } catch (FileNotFoundException e) {
            throw new ImageNotFoundException("Image could not be found");
        }
    }

    @Override
    public String delete(String folderName, String fileName) throws FileStorageException
    {
        return this.fileService.delete(folderName, fileName);
    }

    @Override
    public String delete(String path) throws FileStorageException
    {
        return this.fileService.delete(path);
    }
}
