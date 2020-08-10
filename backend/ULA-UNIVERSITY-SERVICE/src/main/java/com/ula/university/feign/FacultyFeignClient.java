package com.ula.university.feign;

import com.ula.university.domain.model.Faculty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ula-faculty-service")
public interface FacultyFeignClient
{
    @GetMapping("/api/v1/faculty")
    CollectionModel<Faculty> getFaculties(@PathVariable Long univeristyId);
}
