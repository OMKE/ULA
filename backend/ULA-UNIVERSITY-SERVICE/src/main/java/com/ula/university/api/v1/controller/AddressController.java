package com.ula.university.api.v1.controller;

import com.ula.university.api.v1.request.AddressRequest;
import com.ula.university.core.annotation.Authorized;
import com.ula.university.core.annotation.Token;
import com.ula.university.core.util.JWT;
import com.ula.university.dto.model.AddressDTO;
import com.ula.university.dto.response.Response;
import com.ula.university.service.address.AddressService;
import com.ula.university.service.exception.AddressNotFoundException;
import com.ula.university.service.exception.CityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class AddressController
{

    @Autowired
    private AddressService addressService;

    @GetMapping("/contact/address")
    public Response<Object> index()
    {
        return Response.ok().setPayload(addressService.index());
    }

    @GetMapping("/contact/address/{id}")
    public Response<Object> show(@PathVariable("id") Long id)
    {
        try {
            return Response.ok().setPayload(addressService.show(id));
        } catch (AddressNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @PostMapping("/contact/address")
    public Response<Object> store
    (       @Token JWT jwt,
            @Valid @RequestBody AddressRequest addressRequest,
            Errors errors
    )
    {
        try {
            return Response.ok()
                            .setPayload
                                (
                                    this.addressService.store
                                            (
                                            new AddressDTO()
                                                .setStreetName(addressRequest.getStreetName())
                                                .setNumber(addressRequest.getNumber())
                                                .setCityId(addressRequest.getCityId())
                                                .setPostalCode(addressRequest.getPostalCode())
                                            )
                                );
        } catch (CityNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @PutMapping("/contact/address/{id}")
    public Response<Object> update
    (
            @Token JWT jwt,
            @PathVariable("id") Long id,
            @Valid @RequestBody AddressRequest addressRequest,
            Errors errors
    )
    {
        try {
            return Response.ok()
                    .setPayload
                        (
                          this.addressService.update
                                    (
                                    id,
                                    new AddressDTO()
                                        .setStreetName(addressRequest.getStreetName())
                                        .setPostalCode(addressRequest.getPostalCode())
                                        .setCityId(addressRequest.getCityId())
                                        .setNumber(addressRequest.getNumber())
                                    )
                        );
        } catch (AddressNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        } catch (CityNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

    @Authorized("ADMIN")
    @DeleteMapping("/contact/address/{id}")
    public Response<Object> delete(@PathVariable("id") Long id)
    {
        try {
            return Response.ok().setPayload(this.addressService.delete(id));
        } catch (AddressNotFoundException e) {
            return Response.exception().setErrors(e.getMessage());
        }
    }

}
