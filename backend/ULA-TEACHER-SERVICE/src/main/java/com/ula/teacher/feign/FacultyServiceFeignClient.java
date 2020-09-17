package com.ula.teacher.feign;

import com.ula.teacher.api.v1.request.StoreAndUpdateSubjectNotificationRequest;
import com.ula.teacher.dto.SubjectNotificationDTO;
import com.ula.teacher.dto.SubjectWithRealizationIdDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.ula.core.api.response.Response;

import java.util.List;

@FeignClient(value = "ula-faculty-service")
public interface FacultyServiceFeignClient
{
    @GetMapping("/private/teacher/{teacherId}/subject/{subjectId}")
    SubjectWithRealizationIdDTO getSubjectById
            (
            @RequestHeader(value = "Authorization") String token,
            @PathVariable("teacherId") Long teacherId,
            @PathVariable("subjectId") Long subjectId
            );

    @GetMapping("/private/teacher/{teacherId}/subject-notification")
    List<SubjectNotificationDTO> getNotifications
            (
                @RequestHeader(value = "Authorization") String token,
                @PathVariable("teacherId") Long teacherId
            );

    @GetMapping("/private/subject/{id}/notification")
    List<SubjectNotificationDTO> getNotificationsBySubject
            (
                    @RequestHeader(value = "Authorization") String token,
                    @PathVariable("id") Long subjectId
            );
    
    @PostMapping("/private/subject/{id}/notification")
    Response<Object> addNotification
            (
                    @RequestHeader(value = "Authorization") String token,
                    @PathVariable("id") Long subjectId,
                    @RequestBody StoreAndUpdateSubjectNotificationRequest request
                    );

    @DeleteMapping("/private/teacher/{teacherId}/notification/{notificationId}")
    Response<Object> deleteNotification
            (
                    @RequestHeader(value = "Authorization") String token,
                    @PathVariable("teacherId") Long teacherId,
                    @PathVariable("notificationId") Long notificationId
            );
}
