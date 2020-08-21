package com.ula.university.service.contact;

import com.ula.university.domain.model.Location;
import com.ula.university.domain.repository.AddressRepository;
import com.ula.university.domain.repository.LocationRepository;
import com.ula.university.domain.repository.PhoneNumberRepository;
import com.ula.university.dto.model.AddressDTO;
import com.ula.university.dto.model.ContactDTO;
import com.ula.university.dto.model.LocationDTO;
import com.ula.university.dto.model.PhoneNumberDTO;
import com.ula.university.mapper.AddressMapper;
import com.ula.university.mapper.PhoneNumberMapper;
import com.ula.university.service.exception.LocationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService
{
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public ContactDTO index() throws LocationNotFoundException
    {
        List<PhoneNumberDTO> phoneNumberDTOS = PhoneNumberMapper.mapPhoneNumbers(phoneNumberRepository.findByUniversityId(1L));
        List<AddressDTO> addressDTOS = AddressMapper.mapAddresses(this.addressRepository.findAll());
        Location location = this.locationRepository.findById(1L).orElseThrow(() -> new LocationNotFoundException(String.format("Location with id: %s not found.", 1)));
        LocationDTO locationDTO = new LocationDTO()
                .setId(location.getId())
                .setLatitude(location.getLatitude())
                .setLongitude(location.getLongitude())
                .setName(location.getName());

        return new ContactDTO()
                .setAddresses(addressDTOS)
                .setLocation(locationDTO)
                .setPhoneNumbers(phoneNumberDTOS);
    }
}
