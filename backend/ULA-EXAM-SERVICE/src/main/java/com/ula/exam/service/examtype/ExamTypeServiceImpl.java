package com.ula.exam.service.examtype;

import com.ula.exam.domain.model.ExamType;
import com.ula.exam.domain.repository.ExamTypeRepository;
import com.ula.exam.dto.model.ExamTypeDTO;
import com.ula.exam.mapper.ExamTypeMapper;
import com.ula.exam.service.exception.ExamTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamTypeServiceImpl implements ExamTypeService
{

    @Autowired
    private ExamTypeRepository examTypeRepository;

    @Override
    public List<ExamTypeDTO> index()
    {
        return ExamTypeMapper.map(this.examTypeRepository.findAll());
    }

    @Override
    public ExamTypeDTO show(Long id)
    throws ExamTypeNotFoundException
    {
        return ExamTypeMapper.map
                (
                    this.examTypeRepository
                            .findById(id)
                            .orElseThrow(() -> new ExamTypeNotFoundException(String.format("Exam type with id: %s could not be found", id)))
                );
    }

    @Override
    public String store(ExamTypeDTO examTypeDTO)
    {
        ExamType examType = new ExamType()
                    .setName(examTypeDTO.getName());

        this.examTypeRepository.save(examType);

        return "Exam type has been stored";
    }

    @Override
    public String update(Long id, ExamTypeDTO examTypeDTO)
    throws ExamTypeNotFoundException
    {
        ExamType examType = this.examTypeRepository
                .findById(id)
                .orElseThrow(() -> new ExamTypeNotFoundException(String.format("Exam type with id: %s could not be found", id)));

        examType.setName(examTypeDTO.getName());

        this.examTypeRepository.save(examType);

        return "Exam type has been updated";
    }

    @Override
    public String delete(Long id)
    throws ExamTypeNotFoundException
    {
        ExamType examType = this.examTypeRepository
                .findById(id)
                .orElseThrow(() -> new ExamTypeNotFoundException(String.format("Exam type with id: %s could not be found", id)));

        this.examTypeRepository.deleteById(id);

        return "Exam type has been deleted";
    }
}
