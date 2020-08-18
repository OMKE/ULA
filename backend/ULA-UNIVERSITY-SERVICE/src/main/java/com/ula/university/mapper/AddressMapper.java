package com.ula.university.mapper;

import com.ula.university.domain.model.Address;
import com.ula.university.dto.model.AddressDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AddressMapper
{

    public static List<AddressDTO> mapAddresses(List<Address> addresses)
    {
        return addresses.stream().map(AddressMapper::mapAddress).collect(Collectors.toList());
    }

    public static AddressDTO mapAddress(Address address)
    {
        return new AddressDTO()
                    .setId(address.getId())
                    .setCityName(address.getCity().getName())
                    .setStreetName(address.getStreetName())
                    .setNumber(address.getNumber())
                    .setPostalCode(address.getPostalCode());
    }
}
