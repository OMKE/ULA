package com.ula.faculty.service.subjectsyllabus;

import com.ula.faculty.api.v1.request.UpdateSubjectSyllabusRequest;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.SubjectSyllabusNotFoundException;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;
import org.ula.core.exception.NotAuthorizedException;

public interface SubjectSyllabusService
{
    boolean update(Long id, Long teacherId, UpdateSubjectSyllabusRequest request)
    throws SubjectNotFoundException, SubjectSyllabusNotFoundException, NotAuthorizedException, TeacherOnRealizationNotFoundException;

}
