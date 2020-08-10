package com.ula.university.service.university;

import com.ula.university.dto.model.GalleryDTO;
import com.ula.university.dto.model.UniversityDTO;
import com.ula.university.service.exception.GalleryNotFoundException;
import com.ula.university.service.exception.UniversityNotFoundException;

public interface UniversityService
{
    UniversityDTO index() throws UniversityNotFoundException;

    GalleryDTO gallery() throws GalleryNotFoundException;

}
