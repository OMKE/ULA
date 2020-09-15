package com.ula.faculty.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.ula.core.domain.model.UserDTO;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class StudentDTO
{
    private Long id;
    private UserDTO user;
    @JsonIgnore
    private String ssn;
    private String phoneNumber;
    private Date dateOfBirth;
    @JsonIgnore
    private boolean deleted;
    @JsonIgnore
    private Date createdAt;
    @JsonIgnore
    private Date updatedAt;
}
