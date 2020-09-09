package com.ula.student.service.takingexam;

import com.ula.student.dto.StudentDTO;
import com.ula.student.dto.TakingExamDTO;
import com.ula.student.feign.ExamService;
import com.ula.student.service.student.StudentService;
import com.ula.student.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TakingExamServiceImpl implements TakingExamService
{

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserUtil userUtil;

    @Autowired
    private ExamService examService;

    @Override
    public TakingExamDTO show(Long subjectAttendanceId)
    {
        StudentDTO studentDTO = this.studentService.getStudent(this.userUtil.getUsername());
        if(studentDTO != null)
        {
            TakingExamDTO takingExamDTO = this.examService.getTakingExamBySubjectAttendanceId
                    (
                        userUtil.getToken(), studentDTO.getStudentOnYear().getId(), subjectAttendanceId
                    );
            return takingExamDTO;
        } else {
            return null;
        }
    }
}
