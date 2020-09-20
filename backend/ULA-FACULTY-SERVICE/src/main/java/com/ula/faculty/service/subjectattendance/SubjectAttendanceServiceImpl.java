package com.ula.faculty.service.subjectattendance;

import com.ula.faculty.api.v1.request.UpdateSubjectAttendanceFinalGradeRequest;
import com.ula.faculty.domain.guard.SubjectRealizationTeacherGuard;
import com.ula.faculty.domain.model.*;
import com.ula.faculty.domain.repository.StudentOnYearRepository;
import com.ula.faculty.domain.repository.SubjectAttendanceRepository;
import com.ula.faculty.domain.repository.SubjectRealizationRepository;
import com.ula.faculty.domain.repository.TeacherOnRealizationRepository;
import com.ula.faculty.dto.model.SubjectAttendanceDTO;
import com.ula.faculty.dto.model.SubjectAttendanceWithSubjectDTO;
import com.ula.faculty.dto.model.exam.ExamTermDTO;
import com.ula.faculty.feign.ExamFeignClient;
import com.ula.faculty.mapper.SubjectAttendanceMapper;
import com.ula.faculty.mapper.SubjectAttendanceWithSubjectMapper;
import com.ula.faculty.service.exception.*;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.exception.NotAuthorizedException;
import org.ula.core.feign.AuthServiceFeignClient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SubjectAttendanceServiceImpl implements SubjectAttendanceService
{

    @Autowired
    private SubjectAttendanceRepository subjectAttendanceRepository;

    @Autowired
    private SubjectRealizationRepository subjectRealizationRepository;

    @Autowired
    private StudentOnYearRepository studentOnYearRepository;

    @Autowired
    private TeacherOnRealizationRepository teacherOnRealizationRepository;

    @Autowired
    private AuthServiceFeignClient authServiceFeignClient;

    @Autowired
    private ExamFeignClient examFeignClient;


    @Override
    public List<SubjectAttendanceDTO> index()
    {
        return SubjectAttendanceMapper.map(this.subjectAttendanceRepository.findAll());
    }

    @Override
    public List<SubjectAttendanceWithSubjectDTO> getAllByStudentId(Long studentId)
    {

        return SubjectAttendanceWithSubjectMapper.map(this.subjectAttendanceRepository.getAllByStudentId(studentId));
    }

    @Override
    public List<SubjectAttendanceWithSubjectDTO> getAllPassedByStudentId(Long studentId)
    {
        return SubjectAttendanceWithSubjectMapper.map(this.subjectAttendanceRepository.getAllByStudentIdAndFinalGradeNotNull(studentId));
    }

    @Override
    public List<SubjectAttendanceWithSubjectDTO> getAllCurrentByStudentId(Long studentId)
    {
        return SubjectAttendanceWithSubjectMapper.map(this.subjectAttendanceRepository.getAllByStudentIdAndFinalGradeNull(studentId));
    }

    @Override
    public SubjectAttendanceWithSubjectDTO getOneByStudentId(Long resourceId, Long studentId)
    throws SubjectAttendanceNotFoundException
    {
        return SubjectAttendanceWithSubjectMapper.map
                (
                    this.subjectAttendanceRepository
                            .getByIdAndStudentIdAndDeletedFalse(resourceId,studentId)
                            .orElseThrow(
                                () ->
                                new SubjectAttendanceNotFoundException(String.format("Subject attendance with student id: %s could not be found", studentId)))
                );
    }

    @Override
    public List<SubjectAttendanceWithSubjectDTO> getAllBySubjectRealizationIdAndStudentId
    (
            Long subjectRealizationId,
            Long studentId
    )
    {
        return SubjectAttendanceWithSubjectMapper
                .map(this.subjectAttendanceRepository.getAllBySubjectRealizationIdAndStudentIdAndDeletedFalse(subjectRealizationId, studentId));
    }

    @Override
    public SubjectAttendanceDTO getBySubjectIdAndStudentId(Long subjectId, Long studentId)
    throws SubjectRealizationNotFoundException, StudentOnYearNotFoundException, SubjectAttendanceNotFoundException
    {
        SubjectRealization subjectRealization = this.subjectRealizationRepository
                .findBySubjectId(subjectId)
                .orElseThrow(() -> new SubjectRealizationNotFoundException(
                        String.format("Subject realization with subject id: %s could not be found", subjectId)));

        StudentOnYear studentOnYear = this.studentOnYearRepository
                .findById(studentId)
                .orElseThrow(() -> new StudentOnYearNotFoundException(String.format("Student on year with id: %s could not be found", studentId)));

        SubjectAttendance subjectAttendance = this.subjectAttendanceRepository
                .getBySubjectRealizationIdAndStudentId(subjectRealization.getId(), studentOnYear.getId())
                .orElseThrow(() ->
                         new SubjectAttendanceNotFoundException(
                                 String.format("Subject attendance with Subject Realization id: %s and Student on Year id: %s could not be found",
                                               subjectRealization.getId(), studentOnYear.getId()))
                            );

        return SubjectAttendanceMapper.map(subjectAttendance);

    }

    @Override
    public SubjectAttendanceDTO show(Long id)
    throws SubjectAttendanceNotFoundException
    {
        return SubjectAttendanceMapper.map
                (
                    this.subjectAttendanceRepository.findById(id)
                    .orElseThrow(() -> new SubjectAttendanceNotFoundException(String.format("Subject attendance with id: %s could not be found", id)))
                );
    }

    @Override
    public String store(SubjectAttendanceDTO subjectAttendanceDTO, String token)
    throws SubjectRealizationNotFoundException, StudentNotFoundException, StudentOnYearNotFoundException
    {
        SubjectRealization subjectRealization = this.subjectRealizationRepository
                .findById(subjectAttendanceDTO.getSubjectRealizationId())
                .orElseThrow
                    (
                        () -> new SubjectRealizationNotFoundException
                                (
                                    String.format("Subject realization with id: %s could not be found", subjectAttendanceDTO.getSubjectRealizationId())
                                )
                    );

        StudentOnYear studentOnYear = this.studentOnYearRepository
                .findById(subjectAttendanceDTO.getStudentId())
                .orElseThrow
                    (() ->
                         new StudentOnYearNotFoundException
                                 (
                                     String.format("Student on year with id: %s could not be found", subjectAttendanceDTO.getStudentId())
                                 )
                    );

        SubjectAttendance subjectAttendance = new SubjectAttendance()
                .setStudent(studentOnYear)
                .setSubjectRealization(subjectRealization);

        this.subjectAttendanceRepository.save(subjectAttendance);


        String note = "Subject: " + subjectRealization.getSubject().getName();

        return "Subject attendance has been stored";
    }

    @Override
    public Set<SubjectAttendance> storeMany(Set<Subject> subjects, Long studentId)
    throws StudentOnYearNotFoundException
    {
        Set<SubjectAttendance> subjectAttendances = new HashSet<>();

        StudentOnYear studentOnYear = this.studentOnYearRepository
                .findById(studentId)
                .orElseThrow
                        (() ->
                                 new StudentOnYearNotFoundException
                                         (
                                                 String.format("Student on year with id: %s could not be found", studentId)
                                         )
                        );
        for(Subject subject: subjects)
        {
            subjectAttendances
                    .add
                    (
                        this.subjectAttendanceRepository
                                .save(
                                        new SubjectAttendance()
                                            .setSubjectRealization(subject.getSubjectRealization())
                                            .setStudent(studentOnYear)
                                     )
                    );
        }
        return subjectAttendances;
    }

    @Override
    public String update(Long id, SubjectAttendanceDTO subjectAttendanceDTO)
    throws SubjectRealizationNotFoundException, StudentOnYearNotFoundException, SubjectAttendanceNotFoundException
    {
        SubjectRealization subjectRealization = this.subjectRealizationRepository
                .findById(subjectAttendanceDTO.getSubjectRealizationId())
                .orElseThrow
                        (
                                () -> new SubjectRealizationNotFoundException
                                        (
                                                String.format("Subject realization with id: %s could not be found",
                                                              subjectAttendanceDTO.getSubjectRealizationId())
                                        )
                        );

        StudentOnYear studentOnYear = this.studentOnYearRepository
                .findById(subjectAttendanceDTO.getStudentId())
                .orElseThrow
                        (() ->
                                 new StudentOnYearNotFoundException
                                         (
                                                 String.format("Student on year with id: %s could not be found", subjectAttendanceDTO.getStudentId())
                                         )
                        );
        SubjectAttendance subjectAttendance = this.subjectAttendanceRepository
                .findById(subjectAttendanceDTO.getId())
                .orElseThrow(() -> new SubjectAttendanceNotFoundException
                                (
                                    String.format("Subject attendance with id: %s could not be found", subjectAttendanceDTO.getId())
                                )
                            );

        subjectAttendance
                .setStudent(studentOnYear)
                .setSubjectRealization(subjectRealization);
        this.subjectAttendanceRepository.save(subjectAttendance);

        return "Subject attendance has been updated";
    }

    @Override
    public String updateFinalGrade(Long id, Long teacherId, UpdateSubjectAttendanceFinalGradeRequest request)
    throws ExamTermNotFoundException, FifteenDaysPassedAfterEndOfExamTermException, SubjectAttendanceNotFoundException, TeacherOnRealizationNotFoundException, NotAuthorizedException
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd H:m");
        LocalDateTime now = LocalDateTime.now();

        // Get exam Term that is closest to current time
        ExamTermDTO examTerm  = this.examFeignClient.getExamTerm(dtf.format(now));
        if(examTerm != null && examTerm.getEndDate() != null)
        {
            DateTime endDate = new DateTime(examTerm.getEndDate());
            // Check if more than 15 days passed after Exam Term EndTime
            // We're adding 15 days to the ExamTerm End Time,
            // calculate days added to ExamTerm End Time with Current time, if it's bigger than 15, final grade can be updated
            if(Days.daysBetween(Instant.now(), endDate.plusDays(15)).getDays() >= 15)
            {
                SubjectAttendance subjectAttendance = this.subjectAttendanceRepository
                        .findById(id)
                        .orElseThrow(
                                () ->
                                new SubjectAttendanceNotFoundException(String.format("Subject attendance with id: %s could not be found", id))
                                    );
                SubjectRealization subjectRealization = subjectAttendance.getSubjectRealization();
                TeacherOnRealization teacherOnRealization = this.teacherOnRealizationRepository
                        .findByTeacherId(teacherId)
                        .orElseThrow(
                                () ->
                                new TeacherOnRealizationNotFoundException
                                        (String.format("Teacher on realization with teacher id: %s could not be found", teacherId)));

                if(SubjectRealizationTeacherGuard.check(teacherOnRealization.getId(), subjectRealization.getTeachersOnRealization()))
                {
                    subjectAttendance.setFinalGrade(request.getFinalGrade());
                    this.subjectAttendanceRepository.save(subjectAttendance);
                    return "Final grade has been updated";
                } else {
                    throw new NotAuthorizedException("Not authorized");
                }

            } else {
                throw new FifteenDaysPassedAfterEndOfExamTermException
                        ("Final grade can not be updated because more than 15 days passed after Exam Term end time");
            }
        } else {
            throw new ExamTermNotFoundException(String.format("Unable to find exam term"));
        }

    }

    @Override
    public String delete(Long id)
    {
        return null;
    }

    @Override
    public List<Long> getIdsBySubjectId(Long teacherId, Long subjectId)
    throws SubjectRealizationNotFoundException, TeacherOnRealizationNotFoundException, NotAuthorizedException
    {
        SubjectRealization subjectRealization = this.subjectRealizationRepository
                .findBySubjectId(subjectId)
                .orElseThrow(() -> new SubjectRealizationNotFoundException(
                        String.format("Subject realization with subject id: %s could not be found", subjectId)));

        TeacherOnRealization teacherOnRealization = this.teacherOnRealizationRepository
                .findByTeacherId(teacherId)
                .orElseThrow(() -> new TeacherOnRealizationNotFoundException(
                        String.format("Teacher on realization with teacher id: %s could not be found", teacherId))
                            );

        if(SubjectRealizationTeacherGuard.check(teacherOnRealization.getTeacherId(), subjectRealization.getTeachersOnRealization()))
        {
            List<Long> ids = new ArrayList<>();

            List<SubjectAttendance> subjectAttendances = this.subjectAttendanceRepository.findAllBySubjectRealizationId(subjectRealization.getId());

            subjectAttendances.forEach(subject -> ids.add(subject.getId()));

            return ids;

        } else {
            throw new NotAuthorizedException("Teacher is not authorized with provided subject id");
        }

    }
}
