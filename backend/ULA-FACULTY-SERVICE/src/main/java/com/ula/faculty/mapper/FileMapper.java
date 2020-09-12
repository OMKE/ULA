package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.File;
import com.ula.faculty.dto.model.FileDTO;

import java.util.Set;
import java.util.stream.Collectors;

public class FileMapper
{
    public static FileDTO map(File file)
    {
        return new FileDTO()
                .setId(file.getId())
                .setDescription(file.getDescription())
                .setPath(file.getPath())
                .setTeachingMaterialId(file.getTeachingMaterial().getId());
    }

    public static Set<FileDTO> mapFiles(Set<File> files)
    {
        return files.stream().map(FileMapper::map).collect(Collectors.toSet());
    }
}
