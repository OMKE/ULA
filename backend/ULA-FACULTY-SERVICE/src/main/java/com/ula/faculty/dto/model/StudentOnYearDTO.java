package com.ula.faculty.dto.model;

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
public class StudentOnYearDTO
{
    private Long id;
    private Long studentId;
    private List<Long> yearOfStudyIds;
    private Date dateOfEnrollment;
    private String transcriptIdentifier;
    private boolean deleted;
    private Date createdAt;
    private Date updatedAt;
//    private Set<SubjectAttendanceDTO> subjectAttendances;
}
