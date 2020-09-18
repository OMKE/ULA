package com.ula.faculty.api.v1.controller;

import com.ula.faculty.dto.model.TeacherOnRealizationDTO;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;
import com.ula.faculty.service.teacheronrealization.TeacherOnRealizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;

@RestController
public class TeacherOnRealizationController
{

    @Autowired
    private TeacherOnRealizationService teacherOnRealizationService;

    @Authorized("TEACHER")
    @GetMapping("/teacher-on-realization")
    public TeacherOnRealizationDTO getLoggedInTeacherOnRealization()
    {
        try {
            return this.teacherOnRealizationService.getLoggedInTeacherOnRealization();
        } catch (TeacherOnRealizationNotFoundException e) {
            return null;
        }
    }
}
