package com.ula.exam.service.takingexam;

import com.ula.exam.domain.model.TakingExam;
import com.ula.exam.domain.repository.ExamRepository;
import com.ula.exam.domain.repository.TakingExamRepository;
import com.ula.exam.dto.model.SubjectAttendanceDTO;
import com.ula.exam.dto.model.TakingExamDTO;
import com.ula.exam.feign.FacultyFeignClient;
import com.ula.exam.mapper.SubjectAttendanceDTOMapper;
import com.ula.exam.mapper.TakingExamMapper;
import com.ula.exam.service.exception.SubjectAttendanceConflictException;
import com.ula.exam.service.exception.SubjectAttendanceNotFoundException;
import com.ula.exam.service.exception.TakingExamNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.api.response.Response;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class TakingExamServiceImpl implements TakingExamService
{



    @Autowired
    private TakingExamRepository takingExamRepository;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private FacultyFeignClient facultyFeignClient;

    @Override
    public List<TakingExamDTO> index()
    {
        return TakingExamMapper.map(takingExamRepository.findAll());
    }

    @Override
    public TakingExamDTO show(Long id)
    throws TakingExamNotFoundException
    {
        return TakingExamMapper.map
                (
                        takingExamRepository.findById(id).orElseThrow
                                (
                                    () ->
                                    new TakingExamNotFoundException(String.format("Taking exam with id: %s could not be found", id))
                                ).setExams(new HashSet<>(examRepository.findAllByTakingExamId(id)))
                );
    }

    @Override
    public String store(TakingExamDTO takingExamDTO, String token)
    throws SubjectAttendanceNotFoundException, SubjectAttendanceConflictException
    {

        Optional<TakingExam> foundTakingExam = this.takingExamRepository.getBySubjectAttendanceId(takingExamDTO.getSubjectAttendanceId());
        if(foundTakingExam.isPresent())
        {
            throw new SubjectAttendanceConflictException
                    (
                            String.format("Taking exam with subject attendance id: %s already exists", takingExamDTO.getSubjectAttendanceId())
                    );
        }

        // Check if SubjectAttendance exists in ULA-FACULTY-SERVICE DB
        Response<Object> getSubjectAttendaceById = facultyFeignClient.getSubjectAttendanceById(takingExamDTO.getSubjectAttendanceId(), token);
        if(getSubjectAttendaceById.getErrors() != null)
        {
            throw new SubjectAttendanceNotFoundException(getSubjectAttendaceById.getErrors().toString());
        }
        SubjectAttendanceDTO subjectAttendanceDTO = SubjectAttendanceDTOMapper.map(getSubjectAttendaceById.getPayload());

        // Populate Entity
        TakingExam takingExam = new TakingExam()
                    .setNote(takingExamDTO.getNote())
                    .setSubjectAttendanceId(subjectAttendanceDTO.getId())
                    .setExams(new HashSet<>());

        // Save to DB

        this.takingExamRepository.save(takingExam);


        return String.format("Taking exam has been stored");

    }


    @Override
    public String update(Long id, TakingExamDTO takingExamDTO)
    throws TakingExamNotFoundException
    {
        // Find existing based on id
        TakingExam takingExam = this.takingExamRepository
                                    .findById(id)
                                     .orElseThrow
                                         ( () ->
                                            new TakingExamNotFoundException(String.format("Taking exam with id: %s could not be found", id))
                                         );

        // Update fields
        takingExam.setNote(takingExamDTO.getNote())
                  .setPoints(takingExamDTO.getPoints());

        // Save to db

        this.takingExamRepository.save(takingExam);

        return "Taking exam has been updated";
    }

    @Override
    public String delete(Long id)
    throws TakingExamNotFoundException
    {
        TakingExam takingExam = this.takingExamRepository
                .findById(id)
                .orElseThrow(() -> new TakingExamNotFoundException(String.format("Taking exam with id: %s could not be found", id)));

        this.takingExamRepository.deleteById(id);

        return "Taking exam has been deleted";
    }
}
