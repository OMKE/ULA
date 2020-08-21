package com.ula.faculty.service.studyprogram;

import com.ula.faculty.dto.model.StudyProgramDTO;
import com.ula.faculty.dto.model.StudyProgramWithNumberOfPagesDTO;
import com.ula.faculty.dto.model.StudyProgramWithYearsOfStudyDTO;
import com.ula.faculty.service.exception.FacultyNotFoundException;
import com.ula.faculty.service.exception.StudyProgramNotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudyProgramService
{
    StudyProgramWithNumberOfPagesDTO index(Long facultyId, Pageable pageable) throws FacultyNotFoundException;

    StudyProgramDTO show(Long id) throws StudyProgramNotFoundException;

    List<StudyProgramDTO> search(String searchTerm);

    StudyProgramWithYearsOfStudyDTO subjects(Long id) throws StudyProgramNotFoundException;

}
