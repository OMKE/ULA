package com.ula.university.service.address;

import com.ula.university.domain.model.Address;
import com.ula.university.domain.model.City;
import com.ula.university.domain.repository.AddressRepository;
import com.ula.university.domain.repository.CityRepository;
import com.ula.university.dto.model.AddressDTO;
import com.ula.university.service.exception.AddressNotFoundException;
import com.ula.university.service.exception.CityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService
{
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<AddressDTO> index()
    {
        return addressRepository.findAll()
                    .stream()
                    .map(address ->
                            new AddressDTO()
                                    .setId(address.getId())
                                    .setStreetName(address.getStreetName())
                                    .setCityId(address.getCity().getId())
                                    .setPostalCode(address.getPostalCode())
                                    .setNumber(address.getNumber())
                        )
                    .collect(Collectors.toList());
    }

    @Override
    public AddressDTO show(Long id) throws AddressNotFoundException
    {
        Address address = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("Address with id: %s not found"));

        return new AddressDTO()
                .setId(address.getId())
                .setStreetName(address.getStreetName())
                .setCityId(address.getCity().getId())
                .setPostalCode(address.getPostalCode())
                .setNumber(address.getNumber());
    }

    @Override
    public String store(AddressDTO addressDTO) throws CityNotFoundException
    {
        City city = cityRepository.findById(addressDTO.getCityId())
                .orElseThrow(() ->
                        new CityNotFoundException(String.format("City with id: %s not found", addressDTO.getCityId())));


        Address address = new Address()
                    .setCity(city)
                    .setNumber(addressDTO.getNumber())
                    .setPostalCode(addressDTO.getPostalCode())
                    .setStreetName(addressDTO.getStreetName());

        addressRepository.save(address);
        return String.format("Address: %s %s - %s %s was saved",
                address.getStreetName(), address.getNumber(),address.getPostalCode(), address.getCity().getName());
    }

    @Override
    public String update(Long id, AddressDTO addressDTO) throws AddressNotFoundException, CityNotFoundException
    {
        City city = cityRepository.findById(addressDTO.getCityId())
                .orElseThrow(() ->
                        new CityNotFoundException(String.format("City with id: %s not found", addressDTO.getCityId())));

        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(String.format("Address with id: %s not found", id)));

        address.setCity(city)
                .setNumber(addressDTO.getNumber())
                .setPostalCode(addressDTO.getPostalCode())
                .setStreetName(addressDTO.getStreetName());

        addressRepository.save(address);
        return String.format("Address has been updated");
    }

    @Override
    public String delete(Long id) throws AddressNotFoundException
    {
        addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(String.format("Address with id: %s not found", id)));
        addressRepository.deleteById(id);
        return String.format("Address has been deleted");
    }
}
