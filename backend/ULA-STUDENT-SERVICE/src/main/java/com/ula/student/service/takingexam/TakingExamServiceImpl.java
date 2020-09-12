package com.ula.student.service.takingexam;

import com.ula.student.dto.StudentDTO;
import com.ula.student.dto.TakingExamDTO;
import com.ula.student.feign.ExamServiceFeignClient;
import com.ula.student.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.util.JWTUtil;

@Service
public class TakingExamServiceImpl implements TakingExamService
{

    @Autowired
    private StudentService studentService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private ExamServiceFeignClient examServiceFeignClient;

    @Override
    public TakingExamDTO show(Long subjectAttendanceId)
    {
        StudentDTO studentDTO = this.studentService.getStudent(this.jwtUtil.getUsername());
        if(studentDTO != null)
        {
            TakingExamDTO takingExamDTO = this.examServiceFeignClient.getTakingExamBySubjectAttendanceId
                    (
                        jwtUtil.getToken(), studentDTO.getStudentOnYear().getId(), subjectAttendanceId
                    );
            return takingExamDTO;
        } else {
            return null;
        }
    }
}
