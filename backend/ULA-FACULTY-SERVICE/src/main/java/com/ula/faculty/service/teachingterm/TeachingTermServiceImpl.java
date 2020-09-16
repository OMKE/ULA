package com.ula.faculty.service.teachingterm;

import com.ula.faculty.api.v1.request.StoreTeachingTermRequest;
import com.ula.faculty.domain.guard.SubjectRealizationTeacherGuard;
import com.ula.faculty.domain.model.*;
import com.ula.faculty.domain.repository.*;
import com.ula.faculty.dto.model.TeachingTermDTO;
import com.ula.faculty.mapper.TeachingTermMapper;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;
import com.ula.faculty.service.exception.TeachingTypeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.ula.core.exception.NotAuthorizedException;

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

    @Autowired
    private TeachingTermOutcomeRepository teachingTermOutcomeRepository;

    @Autowired
    private TeachingTypeRepository teachingTypeRepository;

    @Autowired
    private TeachingMaterialRepository teachingMaterialRepository;

    @Autowired
    private TeachingMaterialAuthorRepository teachingMaterialAuthorRepository;

    @Autowired
    private TeacherOnRealizationRepository teacherOnRealizationRepository;

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
    public String store(Long teacherId, StoreTeachingTermRequest request)
    throws SubjectRealizationNotFoundException, NotAuthorizedException, TeachingTypeNotFoundException, TeacherOnRealizationNotFoundException
    {
        SubjectRealization subjectRealization = this.subjectRealizationRepository
                .findBySubjectId(request.getSubjectId())
                .orElseThrow(() -> new SubjectRealizationNotFoundException(
                        String.format("Subject realization with subject id: %s could not be found", request.getSubjectId())));


        TeacherOnRealization teacherOnRealization = this.teacherOnRealizationRepository
                    .findByTeacherId(teacherId)
                    .orElseThrow(() -> new TeacherOnRealizationNotFoundException(
                            String.format("Teacher on realization with id: %s could not be found", teacherId)));

        if(SubjectRealizationTeacherGuard.check(subjectRealization.getTeachersOnRealization(), teacherOnRealization.getId()))
        {
            TeachingType type = this.teachingTypeRepository
                    .findById(request.getTypeId())
                    .orElseThrow(() -> new TeachingTypeNotFoundException(String.format("Teaching type with id: %s could not be found", request.getTypeId())));


            TeachingTerm teachingTerm = new TeachingTerm()
                        .setStartTime(request.getStartTime())
                        .setEndTime(request.getEndTime())
                        .setSubjectRealization(subjectRealization)
                        .setType(type);

            this.teachingTermRepository.save(teachingTerm);

            TeachingTermOutcome teachingTermOutcome = new TeachingTermOutcome()
                        .setTeachingTerm(teachingTerm)
                        .setDescription(request.getTeachingTermOutcomeDescription());

            this.teachingTermOutcomeRepository.save(teachingTermOutcome);

            TeachingMaterial teachingMaterial = new TeachingMaterial()
                        .setTeachingTerm(teachingTerm)
                        .setName(request.getTeachingMaterialName())
                        .setPublicationDate(request.getTeachingMaterialPublicationDate());

            this.teachingMaterialRepository.save(teachingMaterial);

            request.getAuthors().forEach(author ->
                    this.teachingMaterialAuthorRepository.save
                            (
                                new TeachingMaterialAuthor()
                                        .setFirstName(author.getFirstName())
                                        .setLastName(author.getLastName())
                                        .setTeachingMaterial(teachingMaterial)
                            )
                                        );

            return "Teaching term has been stored";
        } else {
            throw new NotAuthorizedException(String.format("Teacher with id: %s is not authorized for provided subject", teacherId));
        }
    }


    @Override
    public String update(Long id, Long teacherId, StoreTeachingTermRequest update)
    {
        return null;
    }

    // TODO - file upload, should be refactored so beside file it gets description
    @Override
    public String addFile(Long teachingTermId, Long teacherId,MultipartFile file)
    {
        return null;
    }

    @Override
    public String delete(Long id, Long teacherId)
    {
        return null;
    }
}
