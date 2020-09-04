package com.ula.exam.service.examtype;

import com.ula.exam.dto.model.ExamTypeDTO;
import com.ula.exam.service.exception.ExamTypeNotFoundException;

import java.util.List;

public interface ExamTypeService
{
    List<ExamTypeDTO> index();

    ExamTypeDTO show(Long id)
    throws ExamTypeNotFoundException;

    String store(ExamTypeDTO examTypeDTO);

    String update(Long id, ExamTypeDTO examTypeDTO)
    throws ExamTypeNotFoundException;

    String delete(Long id)
    throws ExamTypeNotFoundException;
}
