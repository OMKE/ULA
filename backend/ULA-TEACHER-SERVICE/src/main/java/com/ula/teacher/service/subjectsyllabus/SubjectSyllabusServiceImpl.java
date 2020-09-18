package com.ula.teacher.service.subjectsyllabus;

import com.ula.teacher.api.v1.request.UpdateSubjectSyllabusRequest;
import com.ula.teacher.domain.model.TeacherDTO;
import com.ula.teacher.feign.AuthServiceFeignClient;
import com.ula.teacher.feign.FacultyServiceFeignClient;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.api.response.Response;
import org.ula.core.util.JWTUtil;

@Service
public class SubjectSyllabusServiceImpl implements SubjectSyllabusService
{

    @Autowired
    private AuthServiceFeignClient authService;

    @Autowired
    private FacultyServiceFeignClient facultyService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public Response<Object> update
    (
            Long subjectId,
            UpdateSubjectSyllabusRequest request
    )
    throws TeacherNotFoundException
    {
        TeacherDTO teacherDTO = this.authService.getTeacher(this.jwtUtil.getToken());
        if(teacherDTO != null && teacherDTO.getId() != null)
        {
            return this.facultyService.updateSubjectSyllabus(this.jwtUtil.getToken(), teacherDTO.getId(), subjectId, request);
        } else {
            throw new TeacherNotFoundException("Not authorized");
        }

    }
}
