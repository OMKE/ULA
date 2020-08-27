package com.ula.authentication.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.ula.core.domain.model.UserDTO;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class AdminDTO
{
    private Long id;
    private UserDTO user;
}
