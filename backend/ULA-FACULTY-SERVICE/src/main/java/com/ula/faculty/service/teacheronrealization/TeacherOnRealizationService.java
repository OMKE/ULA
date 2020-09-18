package com.ula.faculty.service.teacheronrealization;

import com.ula.faculty.dto.model.TeacherOnRealizationDTO;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;

public interface TeacherOnRealizationService
{
    TeacherOnRealizationDTO getLoggedInTeacherOnRealization()
    throws TeacherOnRealizationNotFoundException;
}
