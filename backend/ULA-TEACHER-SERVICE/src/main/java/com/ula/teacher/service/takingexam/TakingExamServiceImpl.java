package com.ula.teacher.service.takingexam;

import com.ula.teacher.dto.SubjectAttendanceDTO;
import com.ula.teacher.dto.TakingExamDTO;
import com.ula.teacher.api.v1.request.UpdateTakingExamRequest;
import com.ula.teacher.feign.ExamServiceFeignClient;
import com.ula.teacher.feign.FacultyServiceFeignClient;
import com.ula.teacher.service.exception.SubjectAttendanceNotFoundException;
import com.ula.teacher.service.exception.TakingExamNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.api.response.Response;
import org.ula.core.util.JWTUtil;

@Service
public class TakingExamServiceImpl implements TakingExamService
{
    @Autowired
    private ExamServiceFeignClient examService;

    @Autowired
    private FacultyServiceFeignClient facultyService;

    @Autowired
    private JWTUtil jwtUtil;



    @Override
    public Response<Object> update(Long subjectId, Long studentId, UpdateTakingExamRequest request)
    throws SubjectAttendanceNotFoundException, TakingExamNotFoundException
    {
        TakingExamDTO takingExamDTO = this.show(subjectId, studentId);
        if(takingExamDTO != null && takingExamDTO.getId() != null)
        {
            return this.examService.updateTakingExam(this.jwtUtil.getToken(), takingExamDTO.getId(), request);
        } else {
            throw new TakingExamNotFoundException(String.format("Taking exam for student id: %s could not be found", studentId));
        }

    }

    @Override
    public TakingExamDTO show(Long subjectId, Long studentId)
    throws SubjectAttendanceNotFoundException
    {
        SubjectAttendanceDTO subjectAttendance = this.facultyService
                .getSubjectAttendanceBySubjectIdAndStudentId(this.jwtUtil.getToken(),subjectId, studentId);

        if(subjectAttendance != null && subjectAttendance.getId() != null)
        {
            return this.examService.getTakingExamBySubjectAttendanceId(this.jwtUtil.getToken(), subjectAttendance.getId());
        } else {
            throw new SubjectAttendanceNotFoundException
                    (String.format("Subject attendance with subject id: %s and student id: %s could not be found", subjectId, studentId));
        }
    }

    @Override
    public Response<Object> getTakingExamPointsCalculated(Long subjectId, Long studentId)
    throws SubjectAttendanceNotFoundException, TakingExamNotFoundException
    {
        TakingExamDTO takingExam = this.show(subjectId, studentId);
        if(takingExam != null && takingExam.getId() != null)
        {
            return this.examService.getTakingExamPointsCalculated(this.jwtUtil.getToken(), takingExam.getId());
        } else {
            throw new TakingExamNotFoundException(String.format("Taking exam not found"));
        }
    }
}
