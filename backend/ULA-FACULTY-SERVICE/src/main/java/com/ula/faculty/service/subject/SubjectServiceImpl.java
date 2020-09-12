package com.ula.faculty.service.subject;

import com.ula.faculty.domain.model.Subject;
import com.ula.faculty.domain.model.SubjectRealization;
import com.ula.faculty.domain.model.SubjectSyllabus;
import com.ula.faculty.domain.model.YearOfStudy;
import com.ula.faculty.domain.repository.SubjectRealizationRepository;
import com.ula.faculty.domain.repository.SubjectRepository;
import com.ula.faculty.domain.repository.SubjectSyllabusRepository;
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

    @Autowired
    private SubjectSyllabusRepository subjectSyllabusRepository;

    @Autowired
    private SubjectRealizationRepository subjectRealizationRepository;

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
    public String store(SubjectDTO subjectDTO)
    throws YearOfStudyNotFoundException
    {
        YearOfStudy yearOfStudy = this.yearOfStudyRepository
                .findById(subjectDTO.getYearOfStudyId())
                .orElseThrow(() -> new YearOfStudyNotFoundException
                        (String.format("Year of study with id: %s could not be found", subjectDTO.getYearOfStudyId())));

        Subject subject = new Subject()
                .setName(subjectDTO.getName())
                .setYearOfStudy(yearOfStudy)
                .setSemester(subjectDTO.getSemester())
                .setEspb(subjectDTO.getEspb())
                .setNumberOfLectures(subjectDTO.getNumberOfLectures())
                .setNumberOfPracticalLectures(subjectDTO.getNumberOfPracticalLectures())
                .setOtherFormsOfLectures(subjectDTO.getOtherFormsOfLectures())
                .setResearchWorks(subjectDTO.getResearchWorks())
                .setOtherLectures(subjectDTO.getOtherLectures())
                .setRequired(subjectDTO.isRequired());

        this.subjectRepository.save(subject);

        this.subjectSyllabusRepository
                .save
                (
                        new SubjectSyllabus()
                            .setContent(subjectDTO.getSyllabus().getContent())
                            .setSubject(subject)
                );
        this.subjectRealizationRepository
                .save
                     (
                             new SubjectRealization()
                                .setSubject(subject)

                     );

        return "Subject has been stored";

    }

    @Override
    public String update(Long id, SubjectDTO subjectDTO)
    throws SubjectNotFoundException, YearOfStudyNotFoundException
    {
        Subject subject = this.subjectRepository
                        .findById(id)
                        .orElseThrow(() -> new SubjectNotFoundException(String.format("Subject with id: %s coudl not be found", id)));

        YearOfStudy yearOfStudy = this.yearOfStudyRepository
                                .findById(subjectDTO.getYearOfStudyId())
                                .orElseThrow
                                    (
                                        () ->
                                        new YearOfStudyNotFoundException
                                                (
                                                    String.format("Year of study with id: %s could not be found", subjectDTO.getYearOfStudyId())
                                                )
                                    );
        subject.setName(subjectDTO.getName())
                .setEspb(subjectDTO.getEspb())
                .setNumberOfLectures(subjectDTO.getNumberOfLectures())
                .setNumberOfPracticalLectures(subjectDTO.getNumberOfPracticalLectures())
                .setOtherFormsOfLectures(subjectDTO.getOtherFormsOfLectures())
                .setRequired(subjectDTO.isRequired())
                .setOtherLectures(subjectDTO.getOtherLectures())
                .setSemester(subjectDTO.getSemester())
                .setYearOfStudy(yearOfStudy)
                .setResearchWorks(subjectDTO.getResearchWorks());

        subject.getSyllabus().setContent(subjectDTO.getSyllabus().getContent());

        this.subjectRepository.save(subject);

        return "Subject has been updated";
    }

    @Override
    public String delete(Long id)
    throws SubjectNotFoundException
    {
        Subject subject = this.subjectRepository
                .findById(id)
                .orElseThrow(() -> new SubjectNotFoundException(String.format("Subject with id: %s could not be found", id)));

        this.subjectRepository.deleteById(id);

        return "Subject has been deleted";
    }

    @Override
    public SubjectDTO show(Long id) throws SubjectNotFoundException
    {
        return SubjectMapper.map(this.subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException(String.format("Subject with id: %s not found", id))));
    }
}
