package com.ula.university.dto.model;

import com.ula.university.domain.model.Album;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class GalleryDTO
{

    private Long id;
    private String description;
    private Set<AlbumDTO> albums = new HashSet<>();


    /*
        @name - albumsToDTO(Set<Album> albums)
        @desc:
            Acts as mapper class, goes over albums and adds them as DTO objects
     */
    public GalleryDTO setAlbumsToDTO(Set<Album> albums)
    {
        for(Album album: albums)
        {
            this.albums.add(
                    new AlbumDTO()
                            .setId(album.getId())
                            .setName(album.getName())
                            .setDescription(album.getDescription())
                            .setGalleryId(this.id)
                            .setImagesToDTO(album.getImages())
                );
        }
        return this;
    }
}
