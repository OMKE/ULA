package com.ula.faculty.service.information;

import com.ula.faculty.dto.model.FacultyInformationDTO;
import com.ula.faculty.service.exception.FacultyInformationException;

import java.util.List;

public interface FacultyInformationService
{
    List<FacultyInformationDTO> index();

    FacultyInformationDTO show(Long id)
    throws FacultyInformationException;

    String store(FacultyInformationDTO facultyInformationDTO);

    String update(Long id, FacultyInformationDTO facultyInformationDTO);

    String delete(Long id);
}
