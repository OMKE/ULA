package com.ula.faculty.service.studyprogram;

import com.ula.faculty.dto.model.StudyProgramDTO;
import com.ula.faculty.dto.model.StudyProgramDTOWithNumberOfPages;
import com.ula.faculty.service.exception.FacultyNotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudyProgramService
{
    StudyProgramDTOWithNumberOfPages index(Long facultyId, Pageable pageable) throws FacultyNotFoundException;

    List<StudyProgramDTO> search(String searchTerm);

}
