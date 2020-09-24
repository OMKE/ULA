package com.ula.teacher.api.v1.controller;


import com.ula.teacher.api.v1.request.StoreTeachingTermRequest;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import com.ula.teacher.service.teachingterm.TeachingTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.api.response.Response;

@RestController
public class TeachingTermController
{
    @Autowired
    private TeachingTermService teachingTermService;


    @Authorized("TEACHER")
    @GetMapping("/teaching-term/subject/{id}")
    public Response<Object> index
    (
            @PathVariable("id") Long subjectId,
            Pageable pageable
    )
    {
        return this.teachingTermService.index(subjectId, pageable);
    }

    @Authorized("TEACHER")
    @PostMapping("/teaching-term")
    public Response<Object> store
    (
            @RequestBody StoreTeachingTermRequest request
    )
    {
        try {
            return this.teachingTermService.store(request);
        } catch (TeacherNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }


}
