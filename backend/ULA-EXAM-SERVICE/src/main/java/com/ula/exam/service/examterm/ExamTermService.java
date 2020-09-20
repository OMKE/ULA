package com.ula.exam.service.examterm;

import com.ula.exam.dto.model.ExamTermDTO;
import com.ula.exam.service.exception.ExamTermNotFoundException;

import java.util.Date;
import java.util.List;

public interface ExamTermService
{
    List<ExamTermDTO> index();

    ExamTermDTO show(Long id)
    throws ExamTermNotFoundException;

    ExamTermDTO showByClosestDate(Date date);

}
