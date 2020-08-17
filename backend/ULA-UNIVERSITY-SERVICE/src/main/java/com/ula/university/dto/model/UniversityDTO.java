
package com.ula.university.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ula.university.domain.model.Faculty;
import com.ula.university.domain.model.PhoneNumber;
import com.ula.university.domain.model.University;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UniversityDTO
{

    private Long id;

    private String name;

    private Date establishmentDate;

    private AddressDTO address;
    private UniversityInformationDTO information;

    private Set<PhoneNumberDTO> phoneNumbers = new HashSet<PhoneNumberDTO>() ;

    private Collection<Faculty> faculties;



    public UniversityDTO setPhoneNumbersToDTO(University university)
    {
        for(PhoneNumber phoneNumber: university.getPhoneNumbers())
        {
            this.phoneNumbers.add(
                    new PhoneNumberDTO()
                        .setNumber(phoneNumber.getNumber())
                        .setContactInfo(phoneNumber.getContactInfo())
            );
        }
        return this;
    }
}

