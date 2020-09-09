package com.ula.student.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDTO
{
    private Long id;
    private UserDTO user;
    private String ssn;
    private String phoneNumber;
    private Date dateOfBirth;
    private StudentOnYearDTO studentOnYear;
}
