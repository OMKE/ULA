package com.ula.university.service.gallery;

import com.ula.university.dto.model.GalleryDTO;
import com.ula.university.service.exception.GalleryNotFoundException;

public interface GalleryService
{
    GalleryDTO index() throws GalleryNotFoundException;
}
