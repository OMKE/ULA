package com.ula.faculty.service.subjectrealization;

import com.ula.faculty.domain.repository.SubjectRealizationRepository;
import com.ula.faculty.dto.model.SubjectRealizationDTO;
import com.ula.faculty.mapper.SubjectRealizationMapper;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectRealizationServiceImpl implements SubjectRealizationService
{
    @Autowired
    private SubjectRealizationRepository subjectRealizationRepository;


    @Override
    public List<SubjectRealizationDTO> index()
    {
        return SubjectRealizationMapper.map(this.subjectRealizationRepository.findAll());
    }

    @Override
    public SubjectRealizationDTO show(Long id)
    throws SubjectRealizationNotFoundException
    {
        return SubjectRealizationMapper.map
                (
                        this.subjectRealizationRepository.findById(id)
                                                         .orElseThrow
                                                                 (
                                                                    () ->
                                                                    new SubjectRealizationNotFoundException(String.format("Subject realization with id: %s could not be found", id))
                                                                 )
                );
    }

    @Override
    public SubjectRealizationDTO showBySubjectId(Long subjectId)
    throws SubjectRealizationNotFoundException
    {
        return SubjectRealizationMapper.map
                (
                        this.subjectRealizationRepository.findBySubjectId(subjectId)
                                                         .orElseThrow
                                                                 (
                                                                         () ->
                                                                                 new SubjectRealizationNotFoundException(String.format("Subject realization with subject id: %s could not be found", subjectId))
                                                                 )
                );
    }

    @Override
    public String store(SubjectRealizationDTO subjectRealizationDTO)
    {
        return null;
    }

    @Override
    public String update(Long id, SubjectRealizationDTO subjectRealizationDTO)
    {
        return null;
    }

    @Override
    public String delete(Long id)
    {
        return null;
    }
}
