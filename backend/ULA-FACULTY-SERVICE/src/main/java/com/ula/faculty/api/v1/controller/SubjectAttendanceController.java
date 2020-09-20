package com.ula.faculty.api.v1.controller;

import com.ula.faculty.api.v1.request.UpdateSubjectAttendanceFinalGradeRequest;
import com.ula.faculty.dto.model.SubjectAttendanceDTO;
import com.ula.faculty.dto.model.SubjectAttendanceWithSubjectDTO;
import com.ula.faculty.service.exception.*;
import com.ula.faculty.service.subjectattendance.SubjectAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;
import org.ula.core.exception.NotAuthorizedException;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class SubjectAttendanceController
{
    @Autowired
    private SubjectAttendanceService subjectAttendanceService;


    @Authorized("[ADMIN,TEACHER]")
    @GetMapping("/subject-attendance")
    public Response<Object> index
    (
    )
    {
        return Response.ok()
                       .setPayload(this.subjectAttendanceService.index());
    }

    @Authorized("[ADMIN,TEACHER]")
    @GetMapping("/subject-attendance/{id}")
    public Response<Object> show
    (
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok()
                           .setPayload(this.subjectAttendanceService.show(id));
        } catch (SubjectAttendanceNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("STUDENT")
    @GetMapping("/private/subject-attendance/student/{id}")
    public List<SubjectAttendanceWithSubjectDTO> indexByStudentId
    (
            @PathVariable("id") Long id
    )
    {
        return this.subjectAttendanceService.getAllByStudentId(id);
    }

    @Authorized("STUDENT")
    @GetMapping("/private/subject-attendance/student/{id}/passed")
    public List<SubjectAttendanceWithSubjectDTO> indexPassedByStudentId
    (
            @PathVariable("id") Long id
    )
    {
        return this.subjectAttendanceService.getAllPassedByStudentId(id);
    }


    @Authorized("STUDENT")
    @GetMapping("/private/subject-attendance/student/{id}/not-passed")
    public List<SubjectAttendanceWithSubjectDTO> indexCurrentByStudentId
    (
            @PathVariable("id") Long id
    )
    {
        return this.subjectAttendanceService.getAllCurrentByStudentId(id);
    }

    @Authorized("[STUDENT,TEACHER]")
    @GetMapping("/private/subject-attendance/student/{studentId}/{id}")
    public SubjectAttendanceWithSubjectDTO showByStudentId
    (
            @PathVariable("studentId") Long studentId,
            @PathVariable("id") Long resourceId
    )
    {
        try {
            return this.subjectAttendanceService.getOneByStudentId(resourceId, studentId);
        } catch (SubjectAttendanceNotFoundException e) {
            return null;
        }
    }

    @Authorized("TEACHER")
    @GetMapping("/private/teacher/subject/{subjectId}/student/{studentId}/attendance")
    public SubjectAttendanceDTO getBySubjectIdAndStudentOnYearId
    (
            @PathVariable("subjectId") Long subjectId,
            @PathVariable("studentId") Long studentId
    )
    {
        try {
            return this.subjectAttendanceService.getBySubjectIdAndStudentId(subjectId, studentId);
        } catch (SubjectRealizationNotFoundException | SubjectAttendanceNotFoundException | StudentOnYearNotFoundException e) {
            return null;
        }
    }

    @Authorized("TEACHER")
    @GetMapping("/private/teacher/{teacherId}/subject/{subjectId}/attendance")
    public List<Long> getSubjectAttendanceIds
    (
            @PathVariable("teacherId") Long teacherId,
            @PathVariable("subjectId") Long subjectId
    )
    {
        try {
            return this.subjectAttendanceService.getIdsBySubjectId(teacherId, subjectId);
        } catch (SubjectRealizationNotFoundException | TeacherOnRealizationNotFoundException | NotAuthorizedException e) {
            return null;
        }
    }

    @Authorized("TEACHER")
    @PutMapping("/private/teacher/{teacherId}/subject-attendance/final-grade/{subjectAttendanceId}")
    public Response<Object> updateFinalGrade
    (
            @PathVariable("teacherId") Long teacherId,
            @PathVariable("subjectAttendanceId") Long subjectAttendanceId,
            @Valid @RequestBody UpdateSubjectAttendanceFinalGradeRequest request
    )
    {
        try {
            return Response.ok().setPayload(this.subjectAttendanceService.updateFinalGrade(subjectAttendanceId, teacherId, request));
        } catch (ExamTermNotFoundException |
                FifteenDaysPassedAfterEndOfExamTermException |
                SubjectAttendanceNotFoundException |
                TeacherOnRealizationNotFoundException |
                NotAuthorizedException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

}
