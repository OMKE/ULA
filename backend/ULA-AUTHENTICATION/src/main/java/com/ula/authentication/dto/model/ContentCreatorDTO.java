package com.ula.authentication.dto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.ula.core.domain.model.UserDTO;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ContentCreatorDTO
{
    private Long id;
    private UserDTO user;
}
