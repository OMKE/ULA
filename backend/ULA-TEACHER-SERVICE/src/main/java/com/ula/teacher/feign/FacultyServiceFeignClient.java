package com.ula.teacher.feign;

import com.ula.teacher.api.v1.request.StoreAndUpdateSubjectNotificationRequest;
import com.ula.teacher.api.v1.request.StoreTeachingTermRequest;
import com.ula.teacher.api.v1.request.UpdateSubjectAttendanceFinalGradeRequest;
import com.ula.teacher.api.v1.request.UpdateSubjectSyllabusRequest;
import com.ula.teacher.dto.*;
import com.ula.teacher.feign.hystrix.FacultyServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.ula.core.api.response.Response;

import java.util.List;

@FeignClient(value = "ula-faculty-service", fallbackFactory = FacultyServiceFallbackFactory.class)
public interface FacultyServiceFeignClient
{

    // Get Subjects
    @GetMapping("/private/teacher/{id}/subject")
    List<SubjectWithRealizationIdDTO> getSubjects
    (
            @RequestHeader("Authorization") String token,
            @PathVariable("id") Long teacherId
    );

    // Get subject by Id
    @GetMapping("/private/teacher/{teacherId}/subject/{subjectId}")
    SubjectWithRealizationIdDTO getSubjectById
            (
            @RequestHeader(value = "Authorization") String token,
            @PathVariable("teacherId") Long teacherId,
            @PathVariable("subjectId") Long subjectId
            );


    // Get all teacher's students
    @GetMapping("/private/teacher/{teacherId}/student")
    List<StudentOnYearDTO> getStudents
            (
                    @RequestHeader(value = "Authorization") String token,
                    @PathVariable("teacherId") Long teacherId,
                    Pageable pageable
            );

    // Search students
    @GetMapping("/private/teacher/student/search")
    Response<Object> searchStudents
    (
            @RequestHeader(value = "Authorization") String token,
            @RequestParam("search") String searchParam
    );

    // Get students based on Subject
    @GetMapping("/private/teacher/subject/{subjectId}/student")
    List<StudentOnYearDTO> getStudentsBySubject
        (
                @RequestHeader("Authorization") String token,
                @PathVariable("subjectId") Long subjectId,
                Pageable pageable
        );

    @GetMapping("/private/teacher/student/{studentId}")
    StudentOnYearDTO getStudentById
            (
                    @RequestHeader("Authorization") String token,
                    @PathVariable("studentId") Long studentId
            );

    // Get teacher's notifications
    @GetMapping("/private/teacher/{teacherId}/subject-notification")
    List<SubjectNotificationDTO> getNotifications
            (
                @RequestHeader(value = "Authorization") String token,
                @PathVariable("teacherId") Long teacherId,
                Pageable pageable
            );

    // Get notifications by subject Id
    @GetMapping("/private/subject/{id}/notification")
    List<SubjectNotificationDTO> getNotificationsBySubject
            (
                    @RequestHeader(value = "Authorization") String token,
                    @PathVariable("id") Long subjectId,
                    Pageable pageable
            );

    // Adds notification on Subject
    @PostMapping("/private/subject/notification")
    Response<Object> addNotification
            (
                    @RequestHeader(value = "Authorization") String token,
                    @RequestBody StoreAndUpdateSubjectNotificationRequest request
                    );

    // Deletes notification
    @DeleteMapping("/private/teacher/{teacherId}/notification/{notificationId}")
    Response<Object> deleteNotification
            (
                    @RequestHeader(value = "Authorization") String token,
                    @PathVariable("teacherId") Long teacherId,
                    @PathVariable("notificationId") Long notificationId
            );

    // Get teaching terms based on Subject Id
    @GetMapping("/subject/{id}/term")
    Response<Object> getTeachingTermsBySubjectId
    (
            @RequestHeader(value = "Authorization") String token,
            @PathVariable("id") Long subjectId
    );

    // Add teaching term
    @PostMapping("/private/teacher/{teacherId}/teaching-term")
    Response<Object> addTeachingTerm
            (
                    @RequestHeader(value = "Authorization") String token,
                    @PathVariable("teacherId") Long teacherId,
                    @RequestBody StoreTeachingTermRequest request
            );


    // Update subject syllabus by Subject Id
    @PutMapping("/private/teacher/{teacherId}/subject-syllabus/{id}")
    Response<Object> updateSubjectSyllabus
            (
                    @RequestHeader(value = "Authorization") String token,
                    @PathVariable("teacherId") Long teacherId,
                    @PathVariable("id") Long subjectId,
                    @RequestBody UpdateSubjectSyllabusRequest request
            );

    @GetMapping("/private/teacher/{teacherId}/subject/{subjectId}/attendance")
    List<Long> getSubjectAttendancesBySubjectId
            (
                    @RequestHeader("Authorization") String token,
                    @PathVariable("teacherId") Long teacherId,
                    @PathVariable("subjectId") Long subjectId
            );

    @GetMapping("/private/teacher/subject/{subjectId}/student/{studentId}/attendance")
    SubjectAttendanceDTO getSubjectAttendanceBySubjectIdAndStudentId
            (
                    @RequestHeader("Authorization") String token,
                    @PathVariable("subjectId") Long subjectId,
                    @PathVariable("studentId") Long studentId
            );

    // Update final grade of student's attendance
    @PutMapping("/private/teacher/{teacherId}/subject-attendance/final-grade/{subjectAttendanceId}")
    Response<Object> updateFinalGrade
    (
            @RequestHeader("Authorization") String token,
            @PathVariable("teacherId") Long teacherId,
            @PathVariable("subjectAttendanceId") Long subjectAttendanceId,
            @RequestBody UpdateSubjectAttendanceFinalGradeRequest request
    );
}
