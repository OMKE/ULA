package com.ula.faculty.service.subject;

import com.ula.faculty.domain.repository.SubjectRepository;
import com.ula.faculty.domain.repository.YearOfStudyRepository;
import com.ula.faculty.dto.model.SubjectDTO;
import com.ula.faculty.mapper.SubjectMapper;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.YearOfStudyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService
{

    @Autowired
    private YearOfStudyRepository yearOfStudyRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<SubjectDTO> index()
    {
        return SubjectMapper.map(this.subjectRepository.findAll());
    }

    /*
        Returns all subjects which have yearOfStudyId, we're using this in YearOfStudyController - /year-of-study/{id]/subjects
     */
    @Override
    public List<SubjectDTO> index(Long yearOfStudyId) throws YearOfStudyNotFoundException
    {
        return SubjectMapper.map
        (
//                Returns list of all subjects which have yearOfStudyId
                this.subjectRepository.findAllByYearOfStudyId
                    (
//                            Returns Id of YearOfStudy if there is one, else throws exception which we can catch in the controller
                        this.yearOfStudyRepository.findById(yearOfStudyId)
                                .orElseThrow(() ->
                                        new YearOfStudyNotFoundException(String.format("Year of study with id: %s not found", yearOfStudyId)
                                )).getId()
                    )
        );
    }

    @Override
    public SubjectDTO show(Long id) throws SubjectNotFoundException
    {
        return SubjectMapper.map(this.subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException(String.format("Subject with id: %s not found", id))));
    }
}
