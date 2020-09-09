package com.ula.exam.feign;

import com.ula.exam.dto.model.SubjectAttendanceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.ula.core.api.response.Response;

@FeignClient("ula-faculty-service")
public interface FacultyFeignClient
{
    @GetMapping("/subject-attendance/{id}")
    Response<Object> getSubjectAttendanceById(@PathVariable("id") Long id, @RequestHeader("Authorization") String token);

    @GetMapping("/private/subject-attendance/student/{studentId}/{id}")
    SubjectAttendanceDTO getByStudentIdAndSubjectAttendanceId
            (
                @RequestHeader("Authorization") String token,
                @PathVariable("studentId") Long studentId,
                @PathVariable("id") Long resourceId
            );
}
