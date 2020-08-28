package com.ula.faculty.api.v1.controller;


import com.ula.faculty.service.exception.StudyProgramNotFoundException;
import com.ula.faculty.service.exception.YearOfStudyNotFoundException;
import com.ula.faculty.service.subject.SubjectService;
import com.ula.faculty.service.yearofstudy.YearOfStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.api.response.Response;

@RestController
public class YearOfStudyController
{
    @Autowired
    private YearOfStudyService yearOfStudyService;

    @Autowired
    private SubjectService subjectService;


    /*
        Returns all year of studies based on study program identificator
     */
    @GetMapping("/study-program/{id}/year-of-study")
    public Response<Object> index(@PathVariable("id") Long studyProgramId)
    {
        try {
            return Response.ok().setPayload(this.yearOfStudyService.index(studyProgramId));
        } catch (StudyProgramNotFoundException e) {
            return Response.exception().setPayload(e.getMessage());
        }
    }

    @GetMapping("/year-of-study/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok().setPayload(this.yearOfStudyService.show(id));
        } catch (YearOfStudyNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @GetMapping("/year-of-study/{id}/subjects")
    public Response<Object> subjects(@PathVariable("id") Long yearOfStudyId)
    {
        try {
            return Response.ok().setPayload(this.subjectService.index(yearOfStudyId));
        } catch (YearOfStudyNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
