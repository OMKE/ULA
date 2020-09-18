package com.ula.teacher.service.teachingterm;

import com.ula.teacher.api.v1.request.StoreTeachingTermRequest;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import org.ula.core.api.response.Response;

public interface TeachingTermService
{
    Response<Object> index(Long subjectId);
    Response<Object> store(StoreTeachingTermRequest request)
    throws TeacherNotFoundException;
}
