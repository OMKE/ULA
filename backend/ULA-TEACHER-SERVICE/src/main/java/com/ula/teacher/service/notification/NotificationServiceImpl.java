package com.ula.teacher.service.notification;

import com.ula.teacher.api.v1.request.StoreAndUpdateSubjectNotificationRequest;
import com.ula.teacher.domain.model.TeacherDTO;
import com.ula.teacher.dto.SubjectNotificationDTO;
import com.ula.teacher.feign.AuthServiceFeignClient;
import com.ula.teacher.feign.FacultyServiceFeignClient;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ula.core.api.response.Response;
import org.ula.core.util.JWTUtil;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService
{

    @Autowired
    private FacultyServiceFeignClient facultyService;

    @Autowired
    private AuthServiceFeignClient authService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public List<SubjectNotificationDTO> index(Pageable pageable)
    throws TeacherNotFoundException
    {
        TeacherDTO teacherDTO = this.authService.getTeacher(this.jwtUtil.getToken());
        if(teacherDTO != null)
        {
            return this.facultyService.getNotifications(jwtUtil.getToken(), teacherDTO.getId(), pageable);
        } else {
            throw new TeacherNotFoundException("Not Authorized");
        }

    }

    @Override
    public List<SubjectNotificationDTO> showBySubjectId(Long subjectId, Pageable pageable)
    {
        return this.facultyService.getNotificationsBySubject(this.jwtUtil.getToken(), subjectId, pageable);
    }

    @Override
    public Response<Object> store(StoreAndUpdateSubjectNotificationRequest request)
    {
        return this.facultyService.addNotification(this.jwtUtil.getToken(), request);
    }

    @Override
    public Response<Object> delete(Long id)
    throws TeacherNotFoundException
    {
        TeacherDTO teacherDTO = this.authService.getTeacher(this.jwtUtil.getToken());
        if(teacherDTO != null)
        {
            return this.facultyService.deleteNotification(jwtUtil.getToken(), teacherDTO.getId(), id);
        } else {
            throw new TeacherNotFoundException("Not Authorized");
        }
    }
}
