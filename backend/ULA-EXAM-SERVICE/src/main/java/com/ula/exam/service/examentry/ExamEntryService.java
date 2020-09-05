package com.ula.exam.service.examentry;

import com.ula.exam.dto.model.ExamEntryDTO;

import java.util.List;

public interface ExamEntryService
{
    List<ExamEntryDTO> index();

    ExamEntryDTO show(Long id);

    String store();


}
