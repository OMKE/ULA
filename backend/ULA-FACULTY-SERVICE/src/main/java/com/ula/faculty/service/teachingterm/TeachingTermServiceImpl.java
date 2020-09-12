package com.ula.faculty.service.teachingterm;

import com.ula.faculty.api.v1.request.StoreTeachingTermRequest;
import com.ula.faculty.domain.model.Subject;
import com.ula.faculty.domain.model.SubjectRealization;
import com.ula.faculty.domain.repository.SubjectRealizationRepository;
import com.ula.faculty.domain.repository.SubjectRepository;
import com.ula.faculty.domain.repository.TeachingTermRepository;
import com.ula.faculty.dto.model.TeachingTermDTO;
import com.ula.faculty.mapper.TeachingTermMapper;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachingTermServiceImpl implements TeachingTermService
{


    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectRealizationRepository subjectRealizationRepository;

    @Autowired
    private TeachingTermRepository teachingTermRepository;


    @Override
    public List<TeachingTermDTO> index(Long subjectId)
    throws SubjectRealizationNotFoundException, SubjectNotFoundException
    {
        Subject subject = this.subjectRepository
                .findById(subjectId)
                .orElseThrow(() -> new SubjectNotFoundException(String.format("Subject with id: %s could not be found", subjectId)));


        SubjectRealization subjectRealization = this.subjectRealizationRepository
                .findBySubjectId(subjectId)
                .orElseThrow(() ->
                        new SubjectRealizationNotFoundException(
                        String.format("Subject realization with subject id: %s could not be found", subject.getId())));


        return TeachingTermMapper.map(this.teachingTermRepository.findBySubjectRealizationId(subjectRealization.getId()));
    }

    @Override
    public TeachingTermDTO show(Long id)
    {
        return null;
    }

    @Override
    public String store(StoreTeachingTermRequest store)
    {
        return null;
    }

    @Override
    public String update(Long id, StoreTeachingTermRequest update)
    {
        return null;
    }

    @Override
    public String delete(Long id)
    {
        return null;
    }
}
