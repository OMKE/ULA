package com.ula.faculty.service.subjectrealization;

import com.ula.faculty.dto.model.SubjectRealizationDTO;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;

import java.util.List;

public interface SubjectRealizationService
{
    List<SubjectRealizationDTO> index();

    SubjectRealizationDTO show(Long id)
    throws SubjectRealizationNotFoundException;

    SubjectRealizationDTO showBySubjectId(Long subjectId)
    throws SubjectRealizationNotFoundException;

    String store(SubjectRealizationDTO subjectRealizationDTO);

    String update(Long id, SubjectRealizationDTO subjectRealizationDTO);

    String delete(Long id);
}
