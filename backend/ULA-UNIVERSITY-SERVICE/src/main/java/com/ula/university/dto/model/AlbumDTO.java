package com.ula.university.dto.model;


import com.ula.university.domain.model.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AlbumDTO
{
    private Long id;
    private Long galleryId;
    private String name;
    private String description;
    private Set<ImageDTO> images = new HashSet<>();


    public AlbumDTO setImagesToDTO(Set<Image> images)
    {
        for(Image image: images)
        {
            this.images.add(
                    new ImageDTO()
                            .setId(image.getId())
                            .setAlbumId(this.id)
                            .setName(image.getName())
                            .setDescription(image.getDescription())
                            .setPath(image.getPath())
            );
        }
        return this;
    }
}
