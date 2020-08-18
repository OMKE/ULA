package com.ula.university.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
public class ContactDTO
{

    private List<PhoneNumberDTO> phoneNumbers;
    private List<AddressDTO> addresses;
    private LocationDTO location;

}
