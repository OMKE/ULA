package com.ula.faculty.api.v1.controller;

import com.ula.faculty.dto.response.Response;
import com.ula.faculty.service.exception.FacultyNotFoundException;
import com.ula.faculty.service.exception.StudyProgramNotFoundException;
import com.ula.faculty.service.studyprogram.StudyProgramService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class StudyProgramController
{

    @Autowired
    private StudyProgramService studyProgramService;

    /*
        @TODO - Improve search capability with spring-search
        @RESOURCE - https://www.sipios.com/blog-tech/how-to-generate-an-advanced-search-api-spring-boot
     */
    @GetMapping("/{id}/study-program")
    public Response<Object> index
    (
            @PathVariable("id") Long facultyId,
            Pageable pageable,
            @RequestParam(value = "search", required = false) Optional<String> searchTerm
    )
    {
        /*
            Checking if there is search query param, if there is, we will return search results instead of all
            We could do this on another url but I chose to be on the same as index
         */
        if(searchTerm.isPresent() && !StringUtils.isEmpty(searchTerm.get()))
        {
            return Response.ok().setPayload(this.studyProgramService.search(searchTerm.get()));
        }
        try {
            return Response.ok().setPayload(this.studyProgramService.index(facultyId, pageable));
        } catch (FacultyNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @GetMapping("/study-program/{id}")
    public Response<Object> show( @PathVariable("id") Long id)
    {
        try {
            return Response.ok().setPayload(this.studyProgramService.show(id));
        } catch (StudyProgramNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @GetMapping("/study-program/{id}/years-and-subjects")
    public Response<Object> subjects(@PathVariable("id") Long id)
    {
        try {
            return Response.ok().setPayload(this.studyProgramService.subjects(id));
        } catch (StudyProgramNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

}
