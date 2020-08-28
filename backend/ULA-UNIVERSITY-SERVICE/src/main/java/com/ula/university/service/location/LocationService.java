package com.ula.university.service.location;

import com.ula.university.dto.model.LocationDTO;
import com.ula.university.service.exception.LocationNotFoundException;

import java.util.List;

public interface LocationService
{
    List<LocationDTO> index();

    LocationDTO show(Long id)
    throws LocationNotFoundException;

    String store(LocationDTO locationDTO);

    String update(Long id, LocationDTO locationDTO);

    String delete(Long id);
}
