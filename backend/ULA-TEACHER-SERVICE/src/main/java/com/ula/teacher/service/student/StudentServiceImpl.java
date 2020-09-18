package com.ula.teacher.service.student;

import com.ula.teacher.dto.StudentDTO;
import com.ula.teacher.feign.FacultyServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ula.core.util.JWTUtil;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{

    @Autowired
    private FacultyServiceFeignClient facultyService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public List<StudentDTO> getStudentsBySubjectId(Long subjectId, Pageable pageable)
    {
        return facultyService.getStudents(jwtUtil.getToken(), subjectId, pageable);
    }
}
