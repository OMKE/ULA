package com.ula.faculty.service.teachingterm;

import com.ula.faculty.api.v1.request.StoreTeachingTermRequest;
import com.ula.faculty.dto.model.TeachingTermDTO;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;

import java.util.List;

public interface TeachingTermService
{
    List<TeachingTermDTO> index(Long subjectId)
    throws SubjectRealizationNotFoundException, SubjectNotFoundException;

    TeachingTermDTO show(Long id);

    String store(StoreTeachingTermRequest store);

    String update(Long id, StoreTeachingTermRequest update);

    String delete(Long id);
}
