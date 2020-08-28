package com.ula.authentication.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
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
    private String ssn;
    private String phoneNumber;
    private Date dateOfBirth;
    private boolean deleted;
    private Date createdAt;
    private Date updatedAt;
}
