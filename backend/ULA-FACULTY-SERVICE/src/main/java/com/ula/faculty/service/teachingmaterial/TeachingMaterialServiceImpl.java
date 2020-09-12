package com.ula.faculty.service.teachingmaterial;

import com.ula.faculty.domain.model.Subject;
import com.ula.faculty.domain.repository.SubjectRepository;
import com.ula.faculty.domain.repository.TeachingMaterialRepository;
import com.ula.faculty.dto.model.TeachingMaterialDTO;
import com.ula.faculty.mapper.TeachingMaterialMapper;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.TeachingMaterialNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeachingMaterialServiceImpl implements TeachingMaterialService
{

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeachingMaterialRepository teachingMaterialRepository;

    @Override
    public List<TeachingMaterialDTO> index(Long subjectId)
    throws SubjectNotFoundException
    {
        Subject subject = this.subjectRepository
                .findById(subjectId)
                .orElseThrow(() -> new SubjectNotFoundException(String.format("Subject with id: %s could not be found", subjectId)));

        return TeachingMaterialMapper.map(subject);

    }

    @Override
    public TeachingMaterialDTO show(Long id)
    throws TeachingMaterialNotFoundException
    {
        return TeachingMaterialMapper
                .map(
                        this.teachingMaterialRepository
                                .findById(id)
                                .orElseThrow
                                        (() ->
                                             new TeachingMaterialNotFoundException(String.format("Teaching material with id: %s could not be found", id))
                                        )

                    );
    }

    @Override
    public String store(TeachingMaterialDTO teachingMaterialDTO)
    {
        return null;
    }

    @Override
    public String update(Long id, TeachingMaterialDTO teachingMaterialDTO)
    {
        return null;
    }

    @Override
    public String delete(Long id)
    {
        return null;
    }
}
