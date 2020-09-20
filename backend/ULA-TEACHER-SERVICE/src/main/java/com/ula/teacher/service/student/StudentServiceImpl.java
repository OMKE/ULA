package com.ula.teacher.service.student;

import com.ula.teacher.domain.model.TeacherDTO;
import com.ula.teacher.dto.StudentOnYearDTO;
import com.ula.teacher.feign.AuthServiceFeignClient;
import com.ula.teacher.feign.FacultyServiceFeignClient;
import com.ula.teacher.service.exception.StudentOnYearNotFoundException;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ula.core.api.response.Response;
import org.ula.core.util.JWTUtil;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{

    @Autowired
    private FacultyServiceFeignClient facultyService;

    @Autowired
    private AuthServiceFeignClient authService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public List<StudentOnYearDTO> index(Pageable pageable)
    throws TeacherNotFoundException
    {
        TeacherDTO teacherDTO = this.authService.getTeacher(this.jwtUtil.getToken());
        if(teacherDTO != null && teacherDTO.getId() != null)
        {
            return this.facultyService.getStudents(this.jwtUtil.getToken(), teacherDTO.getId(), pageable);
        } else {
            throw new TeacherNotFoundException("Not authorized");
        }
    }

    @Override
    public List<StudentOnYearDTO> getStudentsBySubjectId(Long subjectId, Pageable pageable)
    {
        return facultyService.getStudentsBySubject(jwtUtil.getToken(), subjectId, pageable);
    }

    @Override
    public StudentOnYearDTO show(Long studentId)
    throws StudentOnYearNotFoundException
    {
        StudentOnYearDTO student = this.facultyService.getStudentById(this.jwtUtil.getToken(), studentId);
        if(student != null)
        {
            return student;
        } else {
            throw new StudentOnYearNotFoundException(String.format("Student with id: %s could not be found", studentId));
        }
    }

    /*
        - Sends request to get all teacher's students on subject, filters them and finds a student with id
        @TODO Refactor
        - Call Faculty service to get just one student on that subject and return it
     */
    @Override
    public StudentOnYearDTO showInSubject(Long subjectId, Long studentId)
    throws StudentOnYearNotFoundException
    {
        StudentOnYearDTO student = this.getStudentsBySubjectId(subjectId, Pageable.unpaged())
                               .stream()
                               .filter(studentOnYear -> studentOnYear.getId().equals(studentId))
                               .findFirst()
                               .orElseThrow(() -> new
                                      StudentOnYearNotFoundException(String.format("Student on year with id: %s could not be found", studentId)));

        return student;

    }

    @Override
    public Response<Object> search(String searchParam)
    {
        return this.facultyService.searchStudents(this.jwtUtil.getToken(), searchParam);
    }
}
