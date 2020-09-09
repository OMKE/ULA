package com.ula.student.service.exam;

import com.ula.student.dto.ExamDTO;
import com.ula.student.dto.StudentDTO;
import com.ula.student.feign.ExamServiceFeignClient;
import com.ula.student.service.student.StudentService;
import com.ula.student.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExamServiceImpl implements ExamService
{

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserUtil userUtil;

    @Autowired
    private ExamServiceFeignClient examService;

    @Override
    public ExamDTO show(Long subjectAttendanceId, Long examId)
    {

        StudentDTO studentDTO = this.studentService.getStudent(this.userUtil.getUsername());
        if(studentDTO != null)
        {
            ExamDTO examDTO = this.examService.getExamByStudentIdAndSubjectAttendanceIdAndExamId
                    (
                            userUtil.getToken(), studentDTO.getStudentOnYear().getId(), subjectAttendanceId, examId
                    );
            return examDTO;
        } else {
            return null;
        }

    }
}
