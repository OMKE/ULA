package com.ula.faculty.api.v1.controller;


import com.ula.faculty.api.v1.request.StoreAndUpdateSubjectRequest;
import com.ula.faculty.dto.model.SubjectDTO;
import com.ula.faculty.dto.model.SubjectSyllabusDTO;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.YearOfStudyNotFoundException;
import com.ula.faculty.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;

import javax.validation.Valid;

@RestController
@Validated
public class SubjectController extends BaseController
{

    @Autowired
    private SubjectService subjectService;


    @GetMapping("/subject/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok().setPayload(this.subjectService.show(id));
        } catch (SubjectNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @PostMapping("/subject")
    public Response<Object> store
    (
            @Valid @RequestBody StoreAndUpdateSubjectRequest storeRequest,
            Errors errors
    )
    {
        SubjectDTO subjectDTO = new SubjectDTO()
                    .setYearOfStudyId(storeRequest.getYearOfStudyId())
                    .setName(this.sanitize(storeRequest.getName()))
                    .setEspb(storeRequest.getEspb())
                    .setSemester(storeRequest.getSemester())
                    .setRequired(storeRequest.isRequired())
                    .setNumberOfLectures(storeRequest.getNumberOfLectures())
                    .setNumberOfPracticalLectures(storeRequest.getNumberOfPracticalLectures())
                    .setOtherFormsOfLectures(storeRequest.getOtherFormsOfLectures())
                    .setResearchWorks(storeRequest.getResearchWorks())
                    .setOtherLectures(storeRequest.getOtherLectures())
                    .setSyllabus(new SubjectSyllabusDTO().setContent(this.sanitize(storeRequest.getSyllabus())));

        try {
            return Response.ok().setPayload(this.subjectService.store(subjectDTO));
        } catch (YearOfStudyNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @PutMapping("/subject/{id}")
    public Response<Object> update
    (
            @PathVariable("id") Long id,
            @Valid @RequestBody StoreAndUpdateSubjectRequest updateRequest,
            Errors errors
    )
    {
        SubjectDTO subjectDTO = new SubjectDTO()
                .setYearOfStudyId(updateRequest.getYearOfStudyId())
                .setName(this.sanitize(updateRequest.getName()))
                .setEspb(updateRequest.getEspb())
                .setSemester(updateRequest.getSemester())
                .setRequired(updateRequest.isRequired())
                .setNumberOfLectures(updateRequest.getNumberOfLectures())
                .setNumberOfPracticalLectures(updateRequest.getNumberOfPracticalLectures())
                .setOtherFormsOfLectures(updateRequest.getOtherFormsOfLectures())
                .setResearchWorks(updateRequest.getResearchWorks())
                .setOtherLectures(updateRequest.getOtherLectures())
                .setSyllabus(new SubjectSyllabusDTO().setContent(this.sanitize(updateRequest.getSyllabus())));

        try {
            return Response.ok().setPayload(this.subjectService.update(id, subjectDTO));
        } catch (SubjectNotFoundException | YearOfStudyNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @DeleteMapping("/subject/{id}")
    public Response<Object> delete
    (
            @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok().setPayload(this.subjectService.delete(id));
        } catch (SubjectNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
