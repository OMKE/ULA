package com.ula.university.service.gallery;

import com.ula.university.domain.model.Gallery;
import com.ula.university.domain.repository.GalleryRepository;
import com.ula.university.dto.model.GalleryDTO;
import com.ula.university.service.exception.GalleryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GalleryServiceImpl implements GalleryService
{
    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public GalleryDTO index() throws GalleryNotFoundException
    {
        Gallery gallery = this.galleryRepository.findById(1L).orElseThrow(() -> new GalleryNotFoundException("Gallery not found."));
        GalleryDTO galleryDTO = new GalleryDTO()
                .setId(gallery.getId())
                .setDescription(gallery.getDescription())
                .setAlbumsToDTO(gallery.getAlbums());

        return galleryDTO;
    }
}
