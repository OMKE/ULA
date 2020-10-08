package com.ula.authentication.service.contentcreator;

import com.ula.authentication.domain.model.ContentCreator;
import com.ula.authentication.domain.model.User;
import com.ula.authentication.domain.model.UserPermission;
import com.ula.authentication.domain.repository.ContentCreatorRepository;
import com.ula.authentication.domain.repository.PermissionRepository;
import com.ula.authentication.domain.repository.UserPermissionRepository;
import com.ula.authentication.domain.repository.UserRepository;
import com.ula.authentication.dto.model.ContentCreatorDTO;
import com.ula.authentication.mapper.ContentCreatorMapper;
import com.ula.authentication.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContentCreatorServiceImpl implements ContentCreatorService
{


    @Autowired
    private ContentCreatorRepository contentCreatorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Override
    public List<ContentCreatorDTO> index(Pageable pageable)
    {
        return ContentCreatorMapper.map(this.contentCreatorRepository.findAllByDeletedFalse(pageable));
    }

    @Override
    public ContentCreatorDTO show(Long id)
    throws ContentCreatorNotFoundException
    {
        return ContentCreatorMapper.map
                (
                    this.contentCreatorRepository
                    .findById(id)
                    .orElseThrow
                            (() ->
                             new ContentCreatorNotFoundException(String.format("Content creator with id: %s could not be found", id))
                            )
               );
    }

    @Override
    public String store(Long userId)
    throws UserNotFoundException, UserIsAlreadyContentCreator, ContentCreatorAlreadyExists
    {
        User user = this.userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id: %s could not be found", userId)));

        // Check if there is already content creator with user id
        Optional<ContentCreator> foundedContentCreator = this.contentCreatorRepository.findByUserId(userId);
        if(foundedContentCreator.isPresent())
        {
            throw new ContentCreatorAlreadyExists(String.format("Content creator with user id: %s already exists"));
        }


        // check user permissions, if user already have role CONTENT_CREATOR, throw an exception
        if (
                user.getUserPermissions()
                    .stream()
                    .anyMatch
                            (
                                    userPermission -> userPermission
                                            .getPermission().equals(this.permissionRepository.ROLE_CONTENT_CREATOR()) && !userPermission.isDeleted()
                            )
        )
        {
            throw new UserIsAlreadyContentCreator(String.format("User with id: %s is already a content creator", userId));
        }

        user
            .getUserPermissions()
            .add
                (
                    new UserPermission()
                        .setPermission(this.permissionRepository.ROLE_CONTENT_CREATOR())
                        .setUser(user)
                );

        this.userRepository.save(user);

        ContentCreator contentCreator = new ContentCreator()
                    .setUser(user);
        this.contentCreatorRepository.save(contentCreator);
        return "Content creator has been saved";
    }

    @Override
    public String update(Long id, ContentCreatorDTO contentCreatorDTO)
    {
        return null;
    }

    @Override
    public String delete(Long id)
    throws ContentCreatorNotFoundException, UserPermissionException
    {
        ContentCreator contentCreator = this.contentCreatorRepository
                .findById(id)
                .orElseThrow(() -> new ContentCreatorNotFoundException(String.format("Content creator with id: %s could not be found", id)));

        User user = contentCreator.getUser();

        String roleToFind = this.permissionRepository.ROLE_CONTENT_CREATOR().getTitle();

        // Filters through user's permissions and looks for CONTENT_CREATOR title, if it's found, get's first and soft deletes by it's id


        userPermissionRepository.deleteById
                (
                        user.getUserPermissions()
                            .stream()
                            .filter
                                    (
                                            userPermission ->
                                                    userPermission
                                                            .getPermission()
                                                            .getTitle()
                                                            .equals(roleToFind) && !userPermission.isDeleted()
                                    )
                            .findAny().orElseThrow(() -> new UserPermissionException("User permission could not be found")).getId()

                );

        this.contentCreatorRepository.deleteById(id);

        return "Content creator has been deleted";
    }
}
