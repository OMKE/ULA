package com.ula.student.feign;

import com.ula.student.dto.StudentOnYearDTO;
import com.ula.student.dto.SubjectAttendanceWithSubjectDTO;
import com.ula.student.feign.hystrix.FacultyServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(value = "ula-faculty-service", fallbackFactory = FacultyServiceFallbackFactory.class)
public interface FacultyService
{

    @GetMapping("/student-on-year/student/{studentId}")
    StudentOnYearDTO getStudentOnYearByStudentId(@RequestHeader("Authorization") String token, @PathVariable("studentId") Long studentId);

    @GetMapping("/private/subject-attendance/student/{id}")
    List<SubjectAttendanceWithSubjectDTO> getAllSubjectAttendancesWithSubjects(@RequestHeader("Authorization") String token, @PathVariable("id") Long studentOnYearId);

    @GetMapping("/private/subject-attendance/student/{id}/passed")
    List<SubjectAttendanceWithSubjectDTO> getPassedSubjectAttendancesWithSubjects(@RequestHeader("Authorization") String token, @PathVariable("id") Long studentOnYearId);

    @GetMapping("/private/subject-attendance/student/{id}/not-passed")
    List<SubjectAttendanceWithSubjectDTO> getNotPassedSubjectAttendancesWithSubjects(@RequestHeader("Authorization") String token, @PathVariable("id") Long studentOnYearId);

    @GetMapping("/private/subject-attendance/student/{studentId}/{id}")
    SubjectAttendanceWithSubjectDTO getSubjectAttendanceById
            (
            @RequestHeader("Authorization") String token,
            @PathVariable("studentId") Long studentId,
            @PathVariable("id") Long id
            );
}
