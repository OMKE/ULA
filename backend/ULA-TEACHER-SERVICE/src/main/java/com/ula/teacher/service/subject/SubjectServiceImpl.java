package com.ula.teacher.service.subject;

import com.ula.teacher.api.v1.request.UpdateSubjectAttendanceFinalGradeRequest;
import com.ula.teacher.domain.model.TeacherDTO;
import com.ula.teacher.dto.StudentOnYearDTO;
import com.ula.teacher.dto.SubjectWithRealizationIdDTO;
import com.ula.teacher.feign.AuthServiceFeignClient;
import com.ula.teacher.feign.FacultyServiceFeignClient;
import com.ula.teacher.service.exception.StudentOnYearNotFoundException;
import com.ula.teacher.service.exception.SubjectWithRealizationIdNotFoundException;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import com.ula.teacher.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.api.response.Response;
import org.ula.core.util.JWTUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService
{

    @Autowired
    private AuthServiceFeignClient authService;

    @Autowired
    private FacultyServiceFeignClient facultyService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public List<SubjectWithRealizationIdDTO> index()
    {
        TeacherDTO teacherDTO = this.authService.getTeacher(jwtUtil.getToken());
        if(teacherDTO != null)
        {
            return this.facultyService.getSubjects(jwtUtil.getToken(), teacherDTO.getId());
        } else {
            return new ArrayList<>();
        }

    }

    @Override
    public SubjectWithRealizationIdDTO show(Long id)
    throws SubjectWithRealizationIdNotFoundException, TeacherNotFoundException
    {
        TeacherDTO teacherDTO = this.authService.getTeacher(jwtUtil.getToken());
        if(teacherDTO != null)
        {
            SubjectWithRealizationIdDTO subject = this.facultyService.getSubjectById(jwtUtil.getToken(), teacherDTO.getId(), id);
            if(subject != null)
            {
                return subject;
            } else {
                throw new SubjectWithRealizationIdNotFoundException(String.format("Subject with id: %s could not be found", id));
            }
        } else {
            throw new TeacherNotFoundException(String.format("Not Authorized"));
        }
    }

    @Override
    public Response<Object> updateFinalGrade
    (
            Long subjectId,
            Long studentId,
            UpdateSubjectAttendanceFinalGradeRequest request
    )
    throws StudentOnYearNotFoundException, TeacherNotFoundException
    {
        StudentOnYearDTO student = this.studentService.showInSubject(subjectId, studentId);

        TeacherDTO teacherDTO = this.authService.getTeacher(this.jwtUtil.getToken());
        if(teacherDTO != null)
        {
            return this.facultyService.updateFinalGrade(this.jwtUtil.getToken(), teacherDTO.getId(), student.getAttendance().getId(), request);
        } else {
            throw new TeacherNotFoundException("Not authorized");
        }
    }
}
