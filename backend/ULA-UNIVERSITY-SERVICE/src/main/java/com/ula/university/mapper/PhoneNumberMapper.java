package com.ula.university.mapper;

import com.ula.university.domain.model.PhoneNumber;
import com.ula.university.dto.model.PhoneNumberDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneNumberMapper
{

    public static List<PhoneNumberDTO> mapPhoneNumbers(List<PhoneNumber> phoneNumbers)
    {
        return phoneNumbers.stream().map(PhoneNumberMapper::mapPhoneNumber).collect(Collectors.toList());
    }

    public static PhoneNumberDTO mapPhoneNumber(PhoneNumber phoneNumber)
    {
        return new PhoneNumberDTO()
                    .setId(phoneNumber.getId())
                    .setContactInfo(phoneNumber.getContactInfo())
                    .setNumber(phoneNumber.getNumber());
    }

}
