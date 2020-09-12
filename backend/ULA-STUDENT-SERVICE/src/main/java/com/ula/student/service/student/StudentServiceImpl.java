package com.ula.student.service.student;

import com.ula.student.dto.StudentDTO;
import com.ula.student.dto.StudentOnYearDTO;
import com.ula.student.feign.AuthService;
import com.ula.student.feign.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.util.JWTUtil;

@Service
public class StudentServiceImpl implements StudentService
{

    @Autowired
    private AuthService authService;


    @Autowired
    private FacultyService facultyService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public StudentDTO getStudent(String username)
    {
        StudentDTO studentResponse = authService.getStudent(jwtUtil.getToken(), username);
        if(studentResponse != null)
        {
            StudentOnYearDTO studentOnYearDTO = facultyService.getStudentOnYearByStudentId(jwtUtil.getToken(),studentResponse.getId());


            return new StudentDTO()
                    .setId(studentResponse.getId())
                    .setDateOfBirth(studentResponse.getDateOfBirth())
                    .setPhoneNumber(studentResponse.getPhoneNumber())
                    .setSsn(studentResponse.getSsn())
                    .setUser(studentResponse.getUser())
                    .setStudentOnYear(studentOnYearDTO);
        }
        else {
            return null;
        }
    }
}
