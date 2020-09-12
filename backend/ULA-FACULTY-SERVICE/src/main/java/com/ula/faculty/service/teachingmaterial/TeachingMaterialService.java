package com.ula.faculty.service.teachingmaterial;

import com.ula.faculty.dto.model.TeachingMaterialDTO;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.TeachingMaterialNotFoundException;

import java.util.List;

public interface TeachingMaterialService
{
    List<TeachingMaterialDTO> index(Long subjectId)
    throws SubjectNotFoundException;

    TeachingMaterialDTO show(Long id)
    throws TeachingMaterialNotFoundException;

    String store(TeachingMaterialDTO teachingMaterialDTO);

    String update(Long id, TeachingMaterialDTO teachingMaterialDTO);

    String delete(Long id);
}
