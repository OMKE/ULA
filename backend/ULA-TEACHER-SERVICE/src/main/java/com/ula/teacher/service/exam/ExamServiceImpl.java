package com.ula.teacher.service.exam;

import com.ula.teacher.domain.model.TeacherDTO;
import com.ula.teacher.dto.ExamDTO;
import com.ula.teacher.dto.request.CreateExamsRequest;
import com.ula.teacher.feign.AuthServiceFeignClient;
import com.ula.teacher.feign.ExamServiceFeignClient;
import com.ula.teacher.feign.FacultyServiceFeignClient;
import com.ula.teacher.service.exception.SubjectAttendancesNotFoundException;
import com.ula.teacher.service.exception.TeacherNotFoundException;
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
                CreateExamsRequest createExamsRequest = new CreateExamsRequest()
                            .setSubjectAttendanceIds(subjectAttendanceIds)
                            .setExamDTO(examDTO);

                return this.examService.createExam(this.jwtUtil.getToken(), createExamsRequest);
            } else {
                throw new SubjectAttendancesNotFoundException(String.format("Subject attendances are not found"));
            }
        } else {
            throw new TeacherNotFoundException("Not authorized");
        }

    }
}
