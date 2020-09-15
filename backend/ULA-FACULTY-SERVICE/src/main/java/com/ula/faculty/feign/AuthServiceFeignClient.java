package com.ula.faculty.feign;

import com.ula.faculty.domain.model.TeacherDTO;
import com.ula.faculty.dto.model.StudentDTO;
import com.ula.faculty.feign.hystrix.AuthServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "ula-auth-service", fallbackFactory = AuthServiceFallbackFactory.class)
public interface AuthServiceFeignClient
{
    // Returns currently logged teacher
    @GetMapping("/private/teacher")
    TeacherDTO getTeacher(@RequestHeader(value = "Authorization", required = true) String token);

    @GetMapping("/private/student/username/{username}")
    StudentDTO getStudent(@RequestHeader("Authorization") String token, @PathVariable("username") String username);

    // returns all students with ids passed as array
    @PostMapping("/private/student-all")
    List<StudentDTO> getAllStudents(@RequestHeader("Authorization") String token, @RequestBody List<Long> ids);
}
