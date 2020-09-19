package com.ula.faculty.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentOnYearDTO
{
    private Long id;
    private Long studentId;
    private StudentDTO student;
    private List<Long> yearOfStudyIds;
    private Date dateOfEnrollment;
    private String transcriptIdentifier;
    private boolean deleted;
    private Date createdAt;
    private Date updatedAt;
//    private Set<SubjectAttendanceDTO> subjectAttendances;
}
