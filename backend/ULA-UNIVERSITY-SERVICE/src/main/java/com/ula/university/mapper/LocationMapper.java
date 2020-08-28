package com.ula.university.mapper;

import com.ula.university.domain.model.Location;
import com.ula.university.dto.model.LocationDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LocationMapper
{

    public static LocationDTO map(Location location)
    {
        return new LocationDTO()
                    .setId(location.getId())
                    .setLatitude(location.getLatitude())
                    .setLongitude(location.getLongitude())
                    .setName(location.getName());
    }

    public static List<LocationDTO> map(List<Location> locations)
    {
        return locations.stream().map(LocationMapper::map).collect(Collectors.toList());
    }
}
