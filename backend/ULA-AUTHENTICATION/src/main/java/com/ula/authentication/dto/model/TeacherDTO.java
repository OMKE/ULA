package com.ula.authentication.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.ula.core.domain.model.UserDTO;

import java.util.Date;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class TeacherDTO
{
    private Long id;
    private String biography;
    private UserDTO user;
    private boolean deleted;
    private Date createdAt;
    private Date updatedAt;
}
