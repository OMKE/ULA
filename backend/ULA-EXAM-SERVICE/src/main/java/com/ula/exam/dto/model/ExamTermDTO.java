package com.ula.exam.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ExamTermDTO
{

    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
}
