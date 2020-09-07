package com.ula.exam.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "YYYY-MM-DD HH:MM:SS")
    private Date startDate;
    @JsonFormat(pattern = "YYYY-MM-DD HH:MM:SS")
    private Date endDate;
}
