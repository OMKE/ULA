package com.ula.faculty.api.v1.controller;

import com.ula.faculty.api.v1.request.StoreAndUpdateSubjectNotificationRequest;
import com.ula.faculty.dto.model.SubjectNotificationDTO;
import com.ula.faculty.service.exception.StudentOnYearNotFoundException;
import com.ula.faculty.service.exception.SubjectNotificationTypeNotFoundException;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;
import com.ula.faculty.service.subjectnotification.SubjectNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;
import org.ula.core.exception.NotAuthorizedException;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class SubjectNotificationController extends BaseController
{

    @Autowired
    private SubjectNotificationService notificationService;


    @Authorized("[STUDENT,TEACHER]")
    @GetMapping("/private/subject/{id}/notification")
    public List<SubjectNotificationDTO> index
    (
            @PathVariable("id") Long subjectId,
            Pageable pageable
    )
    {
        try {
            return this.notificationService.index(subjectId, pageable);
        } catch (SubjectRealizationNotFoundException e) {
            return null;
        }
    }

    @Authorized("TEACHER")
    @GetMapping("/private/teacher/{teacherId}/subject-notification")
    public List<SubjectNotificationDTO> showTeacherNotifications
    (
            @PathVariable("teacherId") Long teacherId,
            Pageable pageable
    )
    {
        try {
            return this.notificationService.getByTeacherId(teacherId, pageable);
        } catch (TeacherOnRealizationNotFoundException e) {
            return null;
        }
    }

    @Authorized("STUDENT")
    @GetMapping("/private/student/{studentId}/subject-notification")
    public List<SubjectNotificationDTO> showStudentsNotifications
    (
            @PathVariable("studentId") Long studentId,
            Pageable pageable
    )
    {
        try {
            return this.notificationService.getByStudentId(studentId, pageable);
        } catch (StudentOnYearNotFoundException e) {
            return null;
        }
    }

    @PostMapping("/private/subject/{id}/notification")
    @Authorized("TEACHER")
    public Response<Object> store
    (
            @PathVariable("id") Long subjectId,
            @Valid @RequestBody StoreAndUpdateSubjectNotificationRequest storeRequest,
            Errors errors
    )
    {
        storeRequest.setText(this.sanitize(storeRequest.getText()));

        try {
            return Response.ok().setPayload(this.notificationService.store(subjectId, storeRequest));
        } catch (SubjectRealizationNotFoundException |
                TeacherOnRealizationNotFoundException |
                SubjectNotificationTypeNotFoundException |
                NotAuthorizedException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
