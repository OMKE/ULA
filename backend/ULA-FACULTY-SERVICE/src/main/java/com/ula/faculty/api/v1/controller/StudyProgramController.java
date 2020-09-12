package com.ula.faculty.api.v1.controller;


import com.ula.faculty.api.v1.request.StoreAndUpdateStudyProgramRequest;
import com.ula.faculty.service.exception.FacultyNotFoundException;
import com.ula.faculty.service.exception.StudyProgramDegreeNotFoundException;
import com.ula.faculty.service.exception.StudyProgramLocationNotFoundException;
import com.ula.faculty.service.exception.StudyProgramNotFoundException;
import com.ula.faculty.service.studyprogram.StudyProgramService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Validated
public class StudyProgramController extends BaseController
{

    @Autowired
    private StudyProgramService studyProgramService;

    /*
        @TODO - Improve search capability with spring-search
        @RESOURCE - https://www.sipios.com/blog-tech/how-to-generate-an-advanced-search-api-spring-boot
        @TODO - Add option for admin to see deleted study programs
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


    @Authorized("ADMIN")
    @PostMapping("/study-program")
    public Response<Object> store
    (
            @Valid @RequestBody StoreAndUpdateStudyProgramRequest storeRequest,
            Errors errors
    )
    {

        storeRequest.setDescription(this.sanitize(storeRequest.getDescription()))
                    .setName(this.sanitize(storeRequest.getName()));

        try {
            return Response.ok().setPayload(this.studyProgramService.store(storeRequest));
        } catch (StudyProgramLocationNotFoundException | StudyProgramDegreeNotFoundException | FacultyNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @PutMapping("/study-program/{id}")
    public Response<Object> update
    (
            @PathVariable("id") Long id,
            @Valid @RequestBody StoreAndUpdateStudyProgramRequest storeRequest,
            Errors errors
    )
    {

        storeRequest.setDescription(this.sanitize(storeRequest.getDescription()))
                    .setName(this.sanitize(storeRequest.getName()));

        try {
            return Response.ok().setPayload(this.studyProgramService.update(id, storeRequest));
        } catch (StudyProgramLocationNotFoundException | StudyProgramDegreeNotFoundException | FacultyNotFoundException | StudyProgramNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @DeleteMapping("/study-program/{id}")
    public Response<Object> delete
    (
        @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok().setPayload(this.studyProgramService.delete(id));
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
