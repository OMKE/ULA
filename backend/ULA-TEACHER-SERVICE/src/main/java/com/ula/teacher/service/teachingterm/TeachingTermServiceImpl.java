package com.ula.teacher.service.teachingterm;

import com.ula.teacher.api.v1.request.StoreTeachingTermRequest;
import com.ula.teacher.domain.model.TeacherDTO;
import com.ula.teacher.feign.AuthServiceFeignClient;
import com.ula.teacher.feign.FacultyServiceFeignClient;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.api.response.Response;
import org.ula.core.util.JWTUtil;

@Service
public class TeachingTermServiceImpl implements TeachingTermService
{

    @Autowired
    private AuthServiceFeignClient authService;

    @Autowired
    private FacultyServiceFeignClient facultyService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public Response<Object> index(Long subjectId)
    {
        return this.facultyService.getTeachingTermsBySubjectId(this.jwtUtil.getToken(), subjectId);
    }

    @Override
    public Response<Object> store(StoreTeachingTermRequest request)
    throws TeacherNotFoundException
    {
        TeacherDTO teacherDTO = this.authService.getTeacher(this.jwtUtil.getToken());
        if(teacherDTO != null)
        {
            return this.facultyService.addTeachingTerm(jwtUtil.getToken(), teacherDTO.getId(), request);
        } else {
            throw new TeacherNotFoundException(String.format("Not authorized"));
        }
    }
}
