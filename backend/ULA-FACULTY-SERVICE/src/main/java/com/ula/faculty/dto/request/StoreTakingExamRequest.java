package com.ula.faculty.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class StoreTakingExamRequest
{
    private Long subjectAttendanceId;
    private String note;
}
