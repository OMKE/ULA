package com.ula.teacher.service.subjectsyllabus;

import com.ula.teacher.api.v1.request.UpdateSubjectSyllabusRequest;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import org.ula.core.api.response.Response;

public interface SubjectSyllabusService
{

    Response<Object> update(Long subjectId, UpdateSubjectSyllabusRequest request)
    throws TeacherNotFoundException;
}
