package com.ula.teacher.service.subject;

import com.ula.teacher.dto.SubjectWithRealizationIdDTO;
import com.ula.teacher.service.exception.SubjectWithRealizationIdNotFoundException;
import com.ula.teacher.service.exception.TeacherNotFoundException;

import java.util.List;

public interface SubjectService
{
    List<SubjectWithRealizationIdDTO> index();

    SubjectWithRealizationIdDTO show(Long id)
    throws SubjectWithRealizationIdNotFoundException, TeacherNotFoundException;
}
