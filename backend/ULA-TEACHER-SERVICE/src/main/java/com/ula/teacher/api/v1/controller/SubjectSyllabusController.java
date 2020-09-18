package com.ula.teacher.api.v1.controller;

import com.ula.teacher.api.v1.request.UpdateSubjectSyllabusRequest;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import com.ula.teacher.service.subjectsyllabus.SubjectSyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;

@RestController
public class SubjectSyllabusController
{

    @Autowired
    private SubjectSyllabusService subjectSyllabusService;

    @Authorized("TEACHER")
    @PutMapping("/subject/{id}/syllabus")
    public Response<Object> update
    (
            @PathVariable("id") Long subjectId,
            @RequestBody UpdateSubjectSyllabusRequest request
    )
    {
        try {
            return this.subjectSyllabusService.update(subjectId, request);
        } catch (TeacherNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
