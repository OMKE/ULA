package com.ula.authentication.mapper;

import com.ula.authentication.domain.model.ContentCreator;
import com.ula.authentication.dto.model.ContentCreatorDTO;
import org.ula.core.domain.model.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ContentCreatorMapper
{
    public static ContentCreatorDTO map(ContentCreator contentCreator)
    {
        return new ContentCreatorDTO()
                    .setId(contentCreator.getId())
                    .setUser(
                            new UserDTO()
                                .setId(contentCreator.getUser().getId())
                                .setUsername(contentCreator.getUser().getUsername())
                                .setFirstName(contentCreator.getUser().getFirstName())
                                .setLastName(contentCreator.getUser().getLastName())
                                .setEmail(contentCreator.getUser().getEmail())
                                .setProfileImage(contentCreator.getUser().getProfileImage())
                            );
    }

    public static List<ContentCreatorDTO> map(List<ContentCreator> contentCreators)
    {
        return contentCreators.stream().map(ContentCreatorMapper::map).collect(Collectors.toList());
    }
}
