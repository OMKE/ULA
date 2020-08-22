package com.ula.university.service.phonenumber;

import com.ula.university.dto.model.PhoneNumberDTO;
import com.ula.university.service.exception.PhoneNumberNotFoundException;
import com.ula.university.service.exception.UniversityInformationNotFoundException;

import java.util.List;

public interface PhoneNumberService
{

    List<PhoneNumberDTO> index();

    PhoneNumberDTO show(Long id) throws PhoneNumberNotFoundException;

    String store(PhoneNumberDTO phoneNumber) throws UniversityInformationNotFoundException;

    String update(Long id, PhoneNumberDTO phoneNumber) throws PhoneNumberNotFoundException;

    String delete(Long id) throws PhoneNumberNotFoundException;
}
