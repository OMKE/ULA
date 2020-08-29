package com.ula.faculty.service.faculty;

import com.ula.faculty.dto.model.FacultyDTO;
import com.ula.faculty.service.exception.FacultyNotFoundException;

import java.util.List;

public interface FacultyService
{
    List<FacultyDTO> index();
    FacultyDTO show(Long id) throws FacultyNotFoundException;
    String store(FacultyDTO facultyDTO);
    String update(Long id, FacultyDTO facultyDTO)
    throws FacultyNotFoundException;
    String delete(Long id)
    throws FacultyNotFoundException;

}
