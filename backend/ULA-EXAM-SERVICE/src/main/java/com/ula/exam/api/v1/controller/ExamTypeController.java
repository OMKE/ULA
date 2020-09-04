package com.ula.exam.api.v1.controller;

import com.ula.exam.api.v1.request.StoreAndUpdateExamTypeRequest;
import com.ula.exam.dto.model.ExamTypeDTO;
import com.ula.exam.service.examtype.ExamTypeService;
import com.ula.exam.service.exception.ExamTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.ula.core.annotation.Authorized;
import org.ula.core.annotation.Token;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;
import org.ula.core.util.JWT;

import javax.validation.Valid;

@RestController
@Validated
public class ExamTypeController extends BaseController
{
    @Autowired
    private ExamTypeService examTypeService ;

    @GetMapping("/exam-type")
    public Response<Object> index()
    {
        return Response.ok()
                       .setPayload(this.examTypeService.index());
    }
    
    @GetMapping("/exam-type/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok()
                           .setPayload(this.examTypeService.show(id));
        } catch (ExamTypeNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
    
    @Authorized("ADMIN")
    @PostMapping("exam-type")
    public Response<Object> store
    (
        @Token JWT jwt,
        @Valid @RequestBody StoreAndUpdateExamTypeRequest storeRequest,
        Errors errors
    )
    {

        ExamTypeDTO examTypeDTO = new ExamTypeDTO()
                .setName(this.sanitize(storeRequest.getName()));

        return Response.ok()
                       .setPayload(this.examTypeService.store(examTypeDTO));
    }
    
    @Authorized("ADMIN")
    @PutMapping("/exam-type/{id}")
    public Response<Object> update
    (
        @Token JWT jwt,
        @Valid @RequestBody StoreAndUpdateExamTypeRequest updateRequest,
        @PathVariable("id") Long id,
        Errors errors
    )
    {
        ExamTypeDTO examTypeDTO = new ExamTypeDTO()
                    .setName(this.sanitize(updateRequest.getName()));

        try {
            return Response.ok()
                           .setPayload(this.examTypeService.update(id, examTypeDTO));
        } catch (ExamTypeNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
    
    @Authorized("ADMIN")
    @DeleteMapping("/exam-type/{id}")
    public Response<Object> delete
    (
        @Token JWT jwt,
        @PathVariable("id") Long id
    )
    {
        try {
            return Response.ok()
                           .setPayload(this.examTypeService.delete(id));
        } catch (ExamTypeNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }
}
