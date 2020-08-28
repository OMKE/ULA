package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.FacultyInformation;
import com.ula.faculty.dto.model.FacultyInformationDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FacultyInformationMapper
{
    public static FacultyInformationDTO map(FacultyInformation facultyInformation)
    {
        return new FacultyInformationDTO()
                    .setId(facultyInformation.getId())
                    .setFacultyId(facultyInformation.getFaculty().getId())
                    .setPresident(facultyInformation.getPresident())
                    .setMission(facultyInformation.getMission())
                    .setHistory(facultyInformation.getHistory())
                    .setAccreditation(facultyInformation.getAccreditation());
    }

    public static List<FacultyInformationDTO> map(List<FacultyInformation> facultyInformations)
    {
        return facultyInformations.stream().map(FacultyInformationMapper::map).collect(Collectors.toList());
    }
}
