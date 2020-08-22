package com.ula.university.service.address;

import com.ula.university.dto.model.AddressDTO;
import com.ula.university.service.exception.AddressNotFoundException;
import com.ula.university.service.exception.CityNotFoundException;

import java.util.List;

public interface AddressService
{

    List<AddressDTO> index();

    AddressDTO show(Long id) throws AddressNotFoundException;

    String store(AddressDTO addressDTO) throws CityNotFoundException;

    String update(Long id, AddressDTO addressDTO) throws AddressNotFoundException,CityNotFoundException;

    String delete(Long id) throws AddressNotFoundException;
}
