package com.ula.university.api.v1.controller;

import com.ula.university.service.exception.LocationNotFoundException;
import com.ula.university.service.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ula.core.api.BaseController;
import org.ula.core.api.response.Response;


@RestController
@Validated
public class LocationController extends BaseController
{
    @Autowired
    private LocationService locationService;

    @GetMapping("/location")
    public Response<Object> index()
    {
        return Response.ok()
                       .setPayload(this.locationService.index());
    }

    @GetMapping("/location/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok()
                           .setPayload(this.locationService.show(id));
        } catch (LocationNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

                        //@TODO
//    @PostMapping("/location")
//    public Response<Object> store
//            (
//                    @Valid @RequestBody StoreAndUpdateLocationRequest storeRequest,
//                    Errors errors
//            )
//    {
//        return Response.ok()
//                       .setPayload("Not implemented");
//    }
//
//
//    @PutMapping("/location/{id}}")
//    public Response<Object> update
//            (
//                    @Valid @RequestBody StoreAndUpdateLocationRequest updateRequest,
//                    @PathVariable("id") Long id,
//                    Errors errors
//            )
//    {
//        return Response.ok()
//                       .setPayload("Not implemented");
//    }
//
//
//    @DeleteMapping("/location/{id}")
//    public Response<Object> delete
//            (
//                    @PathVariable("id") Long id
//            )
//    {
//        return Response.ok()
//                       .setPayload("Not implemented");
//    }
}
