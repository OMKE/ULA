package com.ula.university.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Accessors(chain = true)
@Data
public class Faculty extends RepresentationModel<Faculty>
{
    @Id
    @GeneratedValue
    private Long id;
    private Long universityId;
    private Long campusId;
    private String name;
    private String icon;

}
