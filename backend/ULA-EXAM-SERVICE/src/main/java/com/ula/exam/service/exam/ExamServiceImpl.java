package com.ula.exam.service.exam;

import com.ula.exam.api.v1.request.UpdateExamRequest;
import com.ula.exam.domain.model.Exam;
import com.ula.exam.domain.model.ExamOutcome;
import com.ula.exam.domain.model.ExamType;
import com.ula.exam.domain.model.TakingExam;
import com.ula.exam.domain.repository.ExamOutcomeRepository;
import com.ula.exam.domain.repository.ExamRepository;
import com.ula.exam.domain.repository.ExamTypeRepository;
import com.ula.exam.domain.repository.TakingExamRepository;
import com.ula.exam.dto.model.ExamDTO;
import com.ula.exam.mapper.ExamMapper;
import com.ula.exam.service.exception.ExamNotFoundException;
import com.ula.exam.service.exception.ExamTypeNotFoundException;
import com.ula.exam.service.exception.TakingExamNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService
{
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamTypeRepository examTypeRepository;

    @Autowired
    private TakingExamRepository takingExamRepository;

    @Autowired
    private ExamOutcomeRepository examOutcomeRepository;

    @Override
    public List<ExamDTO> index()
    {
        return ExamMapper.map(this.examRepository.findAll());
    }

    @Override
    public ExamDTO show(Long id)
    throws ExamNotFoundException
    {
        return ExamMapper.map
                (
                    this.examRepository
                            .findById(id)
                            .orElseThrow(() -> new ExamNotFoundException(String.format("Exam with id: %s could not be found", id)))
                );
    }

    @Override
    public String store(ExamDTO examDTO)
    throws TakingExamNotFoundException, ExamTypeNotFoundException
    {
        // Check if TakingExam exists
        TakingExam takingExam = this.takingExamRepository
                .findById(examDTO.getTakingExamId())
                .orElseThrow(() -> new TakingExamNotFoundException(String.format("Taking exam with id: %s could not be found", examDTO.getTakingExamId())));
        // Check if ExamType exists
        ExamType examType = this.examTypeRepository
                    .findById(examDTO.getExamTypeId())
                    .orElseThrow(() -> new ExamTypeNotFoundException(String.format("Taking exam with id: %s could not be found", examDTO.getExamTypeId())));
        // Populate new Exam
        Exam exam = new Exam()
                .setTakingExam(takingExam)
                .setType(examType)
                .setStartTime(examDTO.getStartTime())
                .setEndTime(examDTO.getEndTime());



        // Save to DB
        this.examRepository.save(exam);

        this.examOutcomeRepository.save(new ExamOutcome().setExam(exam).setDescription("Not yet taken."));

        return "Exam has been stored";
    }

    @Override
    public String update(Long id, UpdateExamRequest updateExamRequest)
    throws ExamNotFoundException
    {

        // Find exam with id
        Exam exam = this.examRepository
                .findById(id)
                .orElseThrow(() -> new ExamNotFoundException(String.format("Exam with id: %s could not be found", id)));


        exam.setPoints(updateExamRequest.getPoints())
            .getExamOutcome().setDescription(updateExamRequest.getDescription());

        this.examRepository.save(exam);

        return "Exam has been updated";
    }

    @Override
    public String delete(Long id)
    throws ExamNotFoundException
    {
        // Find exam with id
        Exam exam = this.examRepository
                .findById(id)
                .orElseThrow(() -> new ExamNotFoundException(String.format("Exam with id: %s could not be found", id)));

        this.examRepository.deleteById(id);

        return "Exam has been deleted";
    }
}
