package com.ula.university.service.phonenumber;

import com.ula.university.domain.model.PhoneNumber;
import com.ula.university.domain.repository.PhoneNumberRepository;
import com.ula.university.domain.repository.UniversityRepository;
import com.ula.university.dto.model.PhoneNumberDTO;
import com.ula.university.service.exception.PhoneNumberNotFoundException;
import com.ula.university.service.exception.UniversityInformationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneNumberServiceImpl implements PhoneNumberService
{

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    private UniversityRepository universityRepository;


    @Override
    public List<PhoneNumberDTO> index()
    {
        return phoneNumberRepository.findAll()
                    .stream()
                    .map
                        (phoneNumber ->
                            new PhoneNumberDTO()
                                .setNumber(phoneNumber.getNumber())
                                .setContactInfo(phoneNumber.getContactInfo())
                                .setId(phoneNumber.getId())
                        )
                    .collect(Collectors.toList());
    }

    @Override
    public PhoneNumberDTO show(Long id) throws PhoneNumberNotFoundException
    {

        PhoneNumber phoneNumber = phoneNumberRepository.findById(id)
                                    .orElseThrow(() -> new PhoneNumberNotFoundException(String.format("Phone number with id: %s not found", id)));


        return new PhoneNumberDTO()
                        .setId(phoneNumber.getId())
                        .setContactInfo(phoneNumber.getContactInfo())
                        .setNumber(phoneNumber.getNumber());
    }

    @Override
    @Transactional
    public String store(PhoneNumberDTO phoneNumberDTO) throws UniversityInformationNotFoundException
    {
        PhoneNumber phoneNumber = new PhoneNumber()
                    .setNumber(phoneNumberDTO.getNumber())
                    .setContactInfo(phoneNumberDTO.getContactInfo())
                    .setUniversity(universityRepository.findByName("University of Los Angeles")
                            .orElseThrow(() -> new UniversityInformationNotFoundException("University of Los Angeles can not be found")));
        phoneNumberRepository.save(phoneNumber);
        return String.format("Number: %s with contact info: %s has been added.", phoneNumberDTO.getNumber(), phoneNumberDTO.getContactInfo());
    }

    @Override
    @Transactional
    public String update(Long id, PhoneNumberDTO phoneNumberDTO) throws PhoneNumberNotFoundException
    {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(id)
                .orElseThrow(() -> new PhoneNumberNotFoundException(String.format("Phone number with id: %s not found", id)));

        phoneNumber.setNumber(phoneNumberDTO.getNumber()).setContactInfo(phoneNumberDTO.getContactInfo());
        phoneNumberRepository.save(phoneNumber);
        return String.format("Phone number has been updated.");
    }

    @Override
    @Transactional
    public String delete(Long id) throws PhoneNumberNotFoundException
    {
        PhoneNumber phoneNumber = phoneNumberRepository.findById(id)
                .orElseThrow(() -> new PhoneNumberNotFoundException(String.format("Phone number with id: %s not found", id)));

        phoneNumberRepository.deleteById(phoneNumber.getId());
        return "Phone number has been deleted.";
    }
}
