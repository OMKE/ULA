package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.Faculty;
import com.ula.faculty.dto.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FacultyMapper
{

    public static FacultyDTO map(Faculty faculty, AddressDTO addressDTO, LocationDTO locationDTO)
    {
        return new FacultyDTO()
                    .setId(faculty.getId())
                    .setName(faculty.getName())
                    .setIcon(faculty.getIcon())
                    .setCampusId(faculty.getCampusId())
                    .setSlug(faculty.getSlug())
                    .setInformation(
                                new FacultyInformationDTO()
                                    .setAccreditation(faculty.getInformation().getAccreditation())
                                    .setHistory(faculty.getInformation().getHistory())
                                    .setMission(faculty.getInformation().getMission())
                                    .setPresident(faculty.getInformation().getPresident())
                                    .setFacultyId(faculty.getId())
                                   )
                    .setContact(
                            new ContactDTO()
                                    .setAddress(addressDTO)
                                    .setEmail(faculty.getInformation().getEmail())
                                    .setPhoneNumber(faculty.getInformation().getPhoneNumber())
                               )
                    .setLocation(locationDTO);
    }

    public static ArrayList<FacultyDTO> map(List<Faculty> faculties)
    {
        return faculties.stream().map
                (faculty ->
                    new FacultyDTO()
                            .setId(faculty.getId())
                            .setCampusId(faculty.getCampusId())
                            .setName(faculty.getName())
                            .setIcon(faculty.getIcon())
                ).collect(Collectors.toCollection(ArrayList::new));
    }

}
