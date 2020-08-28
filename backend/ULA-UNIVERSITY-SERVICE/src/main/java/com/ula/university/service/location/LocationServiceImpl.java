package com.ula.university.service.location;

import com.ula.university.domain.repository.LocationRepository;
import com.ula.university.dto.model.LocationDTO;
import com.ula.university.mapper.LocationMapper;
import com.ula.university.service.exception.LocationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService
{

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<LocationDTO> index()
    {
        return LocationMapper.map(this.locationRepository.findAll());
    }

    @Override
    public LocationDTO show(Long id)
    throws LocationNotFoundException
    {
        return LocationMapper.map
                (
                        this.locationRepository.findById(id).orElseThrow
                                (
                                            () ->
                                                 new LocationNotFoundException(String.format("Location with id: %s could not be found",id))
                                )
                );
    }

    @Override
    public String store(LocationDTO locationDTO)
    {
        return null;
    }

    @Override
    public String update(Long id, LocationDTO locationDTO)
    {
        return null;
    }

    @Override
    public String delete(Long id)
    {
        return null;
    }
}
