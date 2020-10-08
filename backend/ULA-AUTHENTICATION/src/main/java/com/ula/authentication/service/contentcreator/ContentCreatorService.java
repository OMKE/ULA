package com.ula.authentication.service.contentcreator;

import com.ula.authentication.dto.model.ContentCreatorDTO;
import com.ula.authentication.service.exception.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContentCreatorService
{
    List<ContentCreatorDTO> index(Pageable pageable);

    ContentCreatorDTO show(Long id)
    throws ContentCreatorNotFoundException;

    String store(Long userId)
    throws UserNotFoundException, UserIsAlreadyContentCreator, ContentCreatorAlreadyExists;

    String update(Long id, ContentCreatorDTO contentCreatorDTO);

    String delete(Long id)
    throws ContentCreatorNotFoundException, UserPermissionException;
}
