package com.ula.content.service.bootstrap;

import com.ula.content.service.file.FileService;
import com.ula.content.util.StorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FolderInitialization
{

    @Autowired
    private FileService fileService;

    @Autowired
    private StorageUtil storageUtil;

    /*
        Creates basic folder structure based on what is provided in application.yml
     */
    @Bean
    ApplicationRunner initFolders()
    {
        return args -> {


            for (String s: storageUtil.getFolders())
            {
                try {
                    Files.createDirectory(Paths.get( fileService.getStoragePath() + s));
                } catch (FileAlreadyExistsException e){}
            }
        };
    }
}
