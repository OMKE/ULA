package com.ula.student.service.yearofstudy;

import com.ula.student.dto.YearOfStudyDTO;
import com.ula.student.service.exception.YearOfStudyNotFoundException;

import java.util.List;

public interface YearOfStudyService
{
    List<YearOfStudyDTO> index();
    YearOfStudyDTO show(Long id)
    throws YearOfStudyNotFoundException;
}
