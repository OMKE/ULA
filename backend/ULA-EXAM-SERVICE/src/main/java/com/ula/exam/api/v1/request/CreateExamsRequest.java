package com.ula.exam.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ula.exam.dto.model.ExamDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateExamsRequest
{
    @NotNull(message = "Subject attendance Ids are requried")
    private List<Long> subjectAttendanceIds;

    @NotNull(message = "Exam DTO is required")
    private ExamDTO examDTO;

}
