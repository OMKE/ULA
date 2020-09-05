package com.ula.exam.service.examterm;

import com.ula.exam.domain.repository.ExamTermRepository;
import com.ula.exam.dto.model.ExamTermDTO;
import com.ula.exam.mapper.ExamTermMapper;
import com.ula.exam.service.exception.ExamTermNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamTermServiceImpl implements ExamTermService
{
    @Autowired
    private ExamTermRepository examTermRepository;

    @Override
    public List<ExamTermDTO> index()
    {
        return ExamTermMapper.map(this.examTermRepository.findAll());
    }

    @Override
    public ExamTermDTO show(Long id)
    throws ExamTermNotFoundException
    {
        return ExamTermMapper.map
                (
                    this.examTermRepository
                            .findById(id)
                            .orElseThrow(() -> new ExamTermNotFoundException(String.format("Exam term with id: %s could not be found", id)))
                );
    }
}
