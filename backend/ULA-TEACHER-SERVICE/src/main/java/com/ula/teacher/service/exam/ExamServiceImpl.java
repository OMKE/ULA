package com.ula.teacher.service.exam;

import com.ula.teacher.domain.model.TeacherDTO;
import com.ula.teacher.dto.ExamDTO;
import com.ula.teacher.api.v1.request.StoreExamsRequest;
import com.ula.teacher.api.v1.request.UpdateExamRequest;
import com.ula.teacher.dto.TakingExamDTO;
import com.ula.teacher.feign.AuthServiceFeignClient;
import com.ula.teacher.feign.ExamServiceFeignClient;
import com.ula.teacher.feign.FacultyServiceFeignClient;
import com.ula.teacher.service.exception.*;
import com.ula.teacher.service.takingexam.TakingExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.api.response.Response;
import org.ula.core.util.JWTUtil;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService
{

    @Autowired
    private FacultyServiceFeignClient facultyService;

    @Autowired
    private AuthServiceFeignClient authService;

    @Autowired
    private ExamServiceFeignClient examService;

    @Autowired
    private TakingExamService takingExamService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public Response<Object> store(Long subjectId, ExamDTO examDTO)
    throws SubjectAttendancesNotFoundException, TeacherNotFoundException
    {
        TeacherDTO teacherDTO = this.authService.getTeacher(this.jwtUtil.getToken());
        if(teacherDTO != null && teacherDTO.getId() != null)
        {
            List<Long> subjectAttendanceIds = this.facultyService
                    .getSubjectAttendancesBySubjectId(this.jwtUtil.getToken(), teacherDTO.getId(), subjectId);
            if(subjectAttendanceIds != null)
            {
                StoreExamsRequest storeExamsRequest = new StoreExamsRequest()
                            .setSubjectAttendanceIds(subjectAttendanceIds)
                            .setExamDTO(examDTO);

                return this.examService.createExam(this.jwtUtil.getToken(), storeExamsRequest);
            } else {
                throw new SubjectAttendancesNotFoundException(String.format("Subject attendances are not found"));
            }
        } else {
            throw new TeacherNotFoundException("Not authorized");
        }

    }

    @Override
    public ExamDTO show(Long subjectId, Long studentId, Long examId)
    throws SubjectAttendanceNotFoundException, ExamNotFoundException, TakingExamNotFoundException
    {
        TakingExamDTO takingExamDTO = this.takingExamService.show(subjectId, studentId);

        if(takingExamDTO != null && !takingExamDTO.getExams().isEmpty())
        {
            ExamDTO exam = this.getExam(examId, takingExamDTO);
            if(exam != null)
            {
                return exam;
            } else {
                throw new ExamNotFoundException(String.format("Exam with id: %s could not be found", examId));
            }
        } else {
            throw new TakingExamNotFoundException("Taking exam could not be found");
        }
    }

    @Override
    public Response<Object> update(
            Long subjectId, Long studentId, Long examId, UpdateExamRequest request
                                  )
    throws SubjectAttendanceNotFoundException, ExamNotFoundException
    {
        TakingExamDTO takingExamDTO = this.takingExamService.show(subjectId, studentId);

        if(takingExamDTO != null && !takingExamDTO.getExams().isEmpty())
        {
            ExamDTO exam = this.getExam(examId, takingExamDTO);

            return this.examService.updateExam(this.jwtUtil.getToken(), exam.getId(), request);
        } else {
            throw new ExamNotFoundException(String.format("Exam with id: %s could not be found", examId));
        }
    }

    @Override
    public ExamDTO getExam(Long id, TakingExamDTO takingExamDTO)
    {
        ExamDTO examDTO = null;
        for (ExamDTO exam: takingExamDTO.getExams())
        {
            if(exam.getId().equals(id))
            {
                examDTO = exam;
            }
        }

        return examDTO;
    }


}
