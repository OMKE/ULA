package com.ula.faculty.api.v1.controller;

import com.ula.faculty.dto.response.Response;
import com.ula.faculty.service.exception.FacultyNotFoundException;
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
    @GetMapping("/{id}/study-programs")
    public Response<Object> index
    (
            @PathVariable("id") Long facultyId,
            Pageable pageable,
            @RequestParam(value = "search", required = false) Optional<String> searchTerm
    )
    {
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
}
