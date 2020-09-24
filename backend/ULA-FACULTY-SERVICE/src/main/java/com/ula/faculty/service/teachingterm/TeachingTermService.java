package com.ula.faculty.service.teachingterm;

import com.ula.faculty.api.v1.request.StoreTeachingTermRequest;
import com.ula.faculty.dto.model.TeachingTermDTO;
import com.ula.faculty.dto.model.TeachingTypeDTO;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;
import com.ula.faculty.service.exception.TeachingTypeNotFoundException;
import org.springframework.web.multipart.MultipartFile;
import org.ula.core.exception.NotAuthorizedException;

import java.util.List;

public interface TeachingTermService
{
    List<TeachingTermDTO> index(Long subjectId)
    throws SubjectRealizationNotFoundException, SubjectNotFoundException;

    List<TeachingTypeDTO> types();

    TeachingTermDTO show(Long id);

    String store(Long teacherId, StoreTeachingTermRequest request)
    throws SubjectRealizationNotFoundException, NotAuthorizedException, TeachingTypeNotFoundException, TeacherOnRealizationNotFoundException;

    String update(Long id, Long teacherId, StoreTeachingTermRequest update);


    String addFile(Long teachingTermId, Long teacherId, MultipartFile file);

    String delete(Long id, Long teacherId);
}
