package com.ula.faculty.api.v1.controller;

import com.ula.faculty.api.v1.request.UpdateSubjectSyllabusRequest;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.SubjectSyllabusNotFoundException;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;
import com.ula.faculty.service.subjectsyllabus.SubjectSyllabusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;
import org.ula.core.exception.NotAuthorizedException;

import javax.validation.Valid;

@RestController
@Validated
public class SubjectSyllabusController extends BaseController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectSyllabusController.class);

    @Autowired
    private SubjectSyllabusService subjectSyllabusService;

    // update request should contain teacher Id so we can make sure that teacher has an authority over that syllabus
    @Authorized("TEACHER")
    @PutMapping("/private/teacher/{teacherId}/subject-syllabus/{id}")
    public Response<Object> update
    (
            @PathVariable("teacherId") Long teacherId,
            @PathVariable("id") Long id,
            @Valid @RequestBody UpdateSubjectSyllabusRequest request,
            Errors errors
    )
    {
        try {
            request.setContent(this.sanitize(request.getContent()));
            return Response.ok().setPayload(this.subjectSyllabusService.update(id, teacherId, request));
        } catch (SubjectNotFoundException | SubjectSyllabusNotFoundException | NotAuthorizedException | TeacherOnRealizationNotFoundException e) {
            LOGGER.error(e.getMessage());
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
