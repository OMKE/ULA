package com.ula.teacher.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SubjectNotificationDTO
{
    private Long id;
    private String subjectName;
    private String type;
    private Date time;
    private String text;
}
