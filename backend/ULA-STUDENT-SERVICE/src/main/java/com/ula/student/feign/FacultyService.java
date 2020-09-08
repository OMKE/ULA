package com.ula.student.feign;

import com.ula.student.dto.StudentOnYearDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "ula-faculty-service")
public interface FacultyService
{

    @GetMapping("/student-on-year/student/{studentId}")
    StudentOnYearDTO getStudentOnYearByStudentId(@RequestHeader("Authorization") String token, @PathVariable("studentId") Long studentId);
}
