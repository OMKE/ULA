package com.ula.faculty.service.subjectnotification;

import com.ula.faculty.api.v1.request.StoreAndUpdateSubjectNotificationRequest;
import com.ula.faculty.domain.guard.SubjectRealizationTeacherGuard;
import com.ula.faculty.domain.model.*;
import com.ula.faculty.domain.repository.*;
import com.ula.faculty.dto.model.SubjectNotificationDTO;
import com.ula.faculty.feign.AuthServiceFeignClient;
import com.ula.faculty.mapper.SubjectNotificationMapper;
import com.ula.faculty.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ula.core.exception.NotAuthorizedException;
import org.ula.core.util.JWTUtil;

import java.util.ArrayList;
import java.util.List;


@Service
public class SubjectNotificationServiceImpl implements SubjectNotificationService
{

    @Autowired
    private AuthServiceFeignClient authService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private SubjectNotificationRepository subjectNotificationRepository;

    @Autowired
    private SubjectRealizationRepository subjectRealizationRepository;

    @Autowired
    private TeacherOnRealizationRepository teacherOnRealizationRepository;

    @Autowired
    private SubjectNotificationTypeRepository subjectNotificationTypeRepository;

    @Autowired
    private StudentOnYearRepository studentOnYearRepository;



    @Override
    public List<SubjectNotificationDTO> index(Long subjectId, Pageable pageable)
    throws SubjectRealizationNotFoundException
    {
        SubjectRealization subjectRealization = this.subjectRealizationRepository
                .findBySubjectId(subjectId)
                .orElseThrow(() ->
                     new SubjectRealizationNotFoundException(
                             String.format("Subject realization with subject id: %s could not be found", subjectId))
                            );

        return SubjectNotificationMapper.map(this.subjectNotificationRepository.findBySubjectRealizationIdOrderByCreatedAtDesc(subjectRealization.getId(), pageable));
    }

    @Override
    public SubjectNotificationDTO show(Long id)
    throws SubjectNotificationNotFoundException
    {
        return SubjectNotificationMapper.map(
                this.subjectNotificationRepository
                        .findById(id)
                        .orElseThrow(() ->
                                 new SubjectNotificationNotFoundException(String.format("Subject notification with id: %s could not be found", id))
                                    )
                                            );
    }

    @Override
    public List<SubjectNotificationDTO> getByStudentId(Long studentId, Pageable pageable)
    throws StudentOnYearNotFoundException
    {
        StudentOnYear studentOnYear = this.studentOnYearRepository
                .findByStudentIdAndDeletedFalse(studentId)
                .orElseThrow(() -> new StudentOnYearNotFoundException
                                (
                                        String.format("Student on year with student id: %s could not be found", studentId)
                                )
                            );
        ArrayList<Long> subjectRealizationsIds = new ArrayList<>();
        studentOnYear
                .getYearOfStudies()
                .forEach(year ->
                         year
                         .getYearOfStudy()
                         .getSubjects()
                         .forEach(subject ->
                                  subjectRealizationsIds.add(subject.getSubjectRealization().getId())));

        return SubjectNotificationMapper.map(
                this.subjectNotificationRepository.findAllBySubjectRealizationIdInOrderByCreatedAtDesc(subjectRealizationsIds, pageable)
                                            );
    }

    @Override
    public List<SubjectNotificationDTO> getByTeacherId(Long teacherId, Pageable pageable)
    throws TeacherOnRealizationNotFoundException
    {
        TeacherOnRealization teacherOnRealization = this.teacherOnRealizationRepository
                .findByTeacherId(teacherId)
                .orElseThrow(() ->
                        new TeacherOnRealizationNotFoundException(String.format("Teacher on realization with teacher id: %s could not be found", teacherId)));

        ArrayList<Long> subjectRealizationIds = new ArrayList<>();
        teacherOnRealization
                .getSubjectRealization()
                .forEach(sr ->
                    subjectRealizationIds.add(sr.getSubjectRealization().getId())
                        );

        return SubjectNotificationMapper.map(
                this.subjectNotificationRepository.findAllBySubjectRealizationIdInOrderByCreatedAtDesc(subjectRealizationIds, pageable)
                                            );
    }

    @Override
    public String store(Long subjectId, StoreAndUpdateSubjectNotificationRequest storeRequest)
    throws SubjectRealizationNotFoundException, TeacherOnRealizationNotFoundException, SubjectNotificationTypeNotFoundException, NotAuthorizedException
    {
        TeacherDTO teacherDTO = this.authService.getTeacher(this.jwtUtil.getToken());
        SubjectRealization subjectRealization = this.subjectRealizationRepository
                .findBySubjectId(subjectId)
                .orElseThrow(() ->
                         new SubjectRealizationNotFoundException(String.format("Subject realization with subject id: %s could not be found", subjectId))
                            );
        TeacherOnRealization teacherOnRealization = this.teacherOnRealizationRepository
                .findByTeacherId(teacherDTO.getId())
                .orElseThrow(() ->
                             new TeacherOnRealizationNotFoundException
                                     (
                                      String.format("Teacher on realization with teacher id: %s could not be found", teacherDTO.getId())
                                     )
                            );

        SubjectNotificationType subjectNotificationType = this.subjectNotificationTypeRepository
                    .findById(storeRequest.getTypeId())
                    .orElseThrow(() ->
                            new SubjectNotificationTypeNotFoundException
                                    (
                                            String.format("Subject notification type with id: %s could not be found", storeRequest.getTypeId())
                                    )
                                );

        if(teacherDTO != null)
        {
            // Resource Ownership check
            // Check if teacher is on provided realization
            if(SubjectRealizationTeacherGuard.check(teacherOnRealization.getSubjectRealization(), subjectRealization.getId()))
            {
                this.subjectNotificationRepository.save
                        (
                                new SubjectNotification()
                                        .setType(subjectNotificationType)
                                        .setSubjectRealization(subjectRealization)
                                        .setText(storeRequest.getText())
                        );
                return "Subject notification has been stored";
            } else {
                throw new NotAuthorizedException("You're not authorized for given subject");
            }

        } else {
            return "There was a problem while adding subject notification";
        }
    }

    @Override
    public String update(Long id, StoreAndUpdateSubjectNotificationRequest updateRequest)
    {
        return null;
    }

    @Override
    public String delete(Long id)
    {
        return null;
    }
}
