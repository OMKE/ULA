package com.ula.teacher.api.v1.controller;

import com.ula.teacher.api.v1.request.StoreAndUpdateSubjectNotificationRequest;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import com.ula.teacher.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;

@RestController
@Validated
public class NotificationController 
{
    @Autowired
    private NotificationService notificationService ;

    @Authorized("TEACHER")
    @GetMapping("/notification")
    public Response<Object> index
            (
                    Pageable pageable
            )
    {
        try {
            return Response.ok().setPayload(this.notificationService.index(pageable));
        } catch (TeacherNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("TEACHER")
    @GetMapping("/notification/subject/{id}")
    public Response<Object> show
    (
            @PathVariable("id") Long id,
            Pageable pageable
    )
    {
        return Response.ok()
                        .setPayload(this.notificationService.showBySubjectId(id, pageable));
    }
    
    @Authorized("TEACHER")
    @PostMapping("/notification")
    public Response<Object> store
    (
        @RequestBody StoreAndUpdateSubjectNotificationRequest storeRequest
    )
    {
        return this.notificationService.store(storeRequest);
    }

    
    @Authorized("TEACHER")
    @DeleteMapping("/notification/{id}")
    public Response<Object> delete
    (
        @PathVariable("id") Long id
    )
    {
        try {
            return this.notificationService.delete(id);
        } catch (TeacherNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
