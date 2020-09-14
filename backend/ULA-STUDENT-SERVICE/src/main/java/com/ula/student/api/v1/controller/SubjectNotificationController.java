package com.ula.student.api.v1.controller;

import com.ula.student.service.exception.SubjectAttendanceWithSubjectDTONotFoundException;
import com.ula.student.service.subjectnotification.SubjectNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;

@RestController
public class SubjectNotificationController
{
    @Autowired
    private SubjectNotificationService subjectNotificationService;

    @Authorized("STUDENT")
    @GetMapping("/notification")
    public Response<Object> index
    (
            Pageable pageable
    )
    {
        return Response.ok().setPayload(this.subjectNotificationService.index(pageable));
    }

    @Authorized("STUDENT")
    @GetMapping("/subject/{id}/notification")
    public Response<Object> indexBySubjectId
    (
            @PathVariable("id") Long subjectId,
            Pageable pageable
    )
    {
        try {
            return Response.ok().setPayload(this.subjectNotificationService.indexBySubjectId(subjectId, pageable));
        } catch (SubjectAttendanceWithSubjectDTONotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
