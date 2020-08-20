package com.ula.faculty.service.yearofstudy;

import com.ula.faculty.dto.model.YearOfStudyDTO;
import com.ula.faculty.service.exception.StudyProgramNotFoundException;
import com.ula.faculty.service.exception.YearOfStudyNotFoundException;

import java.util.List;

public interface YearOfStudyService
{
    List<YearOfStudyDTO> index(Long studyProgramId) throws StudyProgramNotFoundException;

    YearOfStudyDTO show(Long id) throws YearOfStudyNotFoundException;

}
