package com.ula.university.service.university;


import com.ula.university.domain.model.Gallery;
import com.ula.university.domain.model.University;
import com.ula.university.domain.repository.GalleryRepository;
import com.ula.university.domain.repository.UniversityRepository;
import com.ula.university.dto.model.AddressDTO;
import com.ula.university.dto.model.GalleryDTO;
import com.ula.university.dto.model.UniversityDTO;
import com.ula.university.service.exception.GalleryNotFoundException;
import com.ula.university.service.exception.UniversityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UniversityServiceImpl implements UniversityService 
{


    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public UniversityDTO index() throws UniversityNotFoundException
    {
        University university = this.universityRepository.findByName("University of Los Angeles").orElseThrow(() -> new UniversityNotFoundException("University of Los Angeles not found."));

        UniversityDTO universityDTO = new UniversityDTO()
                    .setName(university.getName())
                    .setAddress(
                            new AddressDTO()
                                    .setNumber(university.getAddress().getNumber())
                                    .setCityName(university.getAddress().getCity().getName())
                                    .setPostalCode(university.getAddress().getPostalCode())
                                    .setStreetName(university.getAddress().getStreetName())
                    )
                    .setEstablishmentDate(university.getEstablishmentDate())
                    .setPhoneNumbersToDTO(university);

        return universityDTO;
    }


    @Override
    public GalleryDTO gallery() throws GalleryNotFoundException
    {
        Gallery gallery = this.galleryRepository.findById(1L).orElseThrow(() -> new GalleryNotFoundException("Gallery not found."));
        GalleryDTO galleryDTO = new GalleryDTO()
                    .setId(gallery.getId())
                    .setDescription(gallery.getDescription())
                    .setAlbumsToDTO(gallery.getAlbums());

        return galleryDTO;
    }
}
