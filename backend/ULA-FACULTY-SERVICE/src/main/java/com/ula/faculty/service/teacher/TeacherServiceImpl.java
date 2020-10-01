package com.ula.faculty.service.teacher;

import com.ula.faculty.domain.model.*;
import com.ula.faculty.domain.repository.*;
import com.ula.faculty.dto.model.StudentDTO;
import com.ula.faculty.dto.model.StudentOnYearDTO;
import com.ula.faculty.dto.model.SubjectWithRealizationIdDTO;
import com.ula.faculty.feign.AuthServiceFeignClient;
import com.ula.faculty.mapper.StudentOnYearMapper;
import com.ula.faculty.mapper.SubjectWithRealizationMapper;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;
import com.ula.faculty.service.exception.TeacherSubjectRealizationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ula.core.util.JWTUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService
{
    @Autowired
    private TeacherOnRealizationRepository teacherOnRealizationRepository;

    @Autowired
    private TeacherSubjectRealizationRepository teacherSubjectRealizationRepository;

    @Autowired
    private SubjectRealizationRepository subjectRealizationRepository;

    @Autowired
    private AuthServiceFeignClient authService;

    @Autowired
    private StudentOnYearRepository studentOnYearRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private SubjectAttendanceRepository subjectAttendanceRepository;



    @Override
    public List<SubjectWithRealizationIdDTO> subjects(Long teacherId)
    throws TeacherOnRealizationNotFoundException
    {


        TeacherOnRealization teacherOnRealization = this.teacherOnRealizationRepository
                .findByTeacherId(teacherId)
                .orElseThrow(() ->
                             new TeacherOnRealizationNotFoundException(
                             String.format("Teacher on realization with teacher id: %s could not be found", teacherId))
                            );

        return SubjectWithRealizationMapper.map(teacherOnRealization.getSubjectRealization());

    }

    @Override
    public SubjectWithRealizationIdDTO subject(Long teacherId, Long subjectId)
    throws SubjectNotFoundException, TeacherOnRealizationNotFoundException, TeacherSubjectRealizationNotFoundException
    {
        SubjectRealization subjectRealization = this.subjectRealizationRepository
                .findBySubjectId(subjectId)
                .orElseThrow(() ->
                         new SubjectNotFoundException(String.format("Subject realization with subject id: %s could not be found", subjectId)));
        TeacherOnRealization teacherOnRealization = this.teacherOnRealizationRepository
                .findByTeacherId(teacherId)
                .orElseThrow(() ->
                        new TeacherOnRealizationNotFoundException(String.format("Teacher on realization with teacher id: %s could not be found", teacherId)));

        TeacherSubjectRealization teacherSubjectRealization =
                this.teacherSubjectRealizationRepository
                        .findBySubjectRealizationIdAndTeacherOnRealizationId(subjectRealization.getId(), teacherOnRealization.getId())
                        .orElseThrow(() ->
                                     new TeacherSubjectRealizationNotFoundException(
                                 String.format("Teacher subject realization with teacher id: %s and subject realization id: %s could not be found",
                                               teacherId, subjectId)));

        return SubjectWithRealizationMapper.map(teacherSubjectRealization);
    }

    @Override
    public List<StudentOnYearDTO> students(Long teacherId, Pageable pageable)
    throws TeacherOnRealizationNotFoundException
    {
        TeacherOnRealization teacherOnRealization = this.teacherOnRealizationRepository
                .findByTeacherId(teacherId)
                .orElseThrow(() ->
                             new TeacherOnRealizationNotFoundException
                             (
                                String.format("Teacher on realization with teacher id: %s could not be found", teacherId)
                             )
                            );


        List<Long> subjectRealizationIds = teacherOnRealization
                .getSubjectRealization()
                .stream()
                .mapToLong(sR -> sR.getSubjectRealization().getId())
                .boxed()
                .collect(Collectors.toList());

        List<SubjectAttendance> subjectAttendances = this.subjectAttendanceRepository.findAllBySubjectRealizationIdIn(subjectRealizationIds, pageable);

        List<Long> studentIds = new ArrayList<>();
        subjectAttendances.forEach(sA -> studentIds.add(sA.getStudent().getStudentId()));

        List<StudentDTO> studentDTOS = this.authService.getAllStudents(jwtUtil.getToken(), studentIds);

        List<Long> studentIdsDTO = studentDTOS.stream().mapToLong(StudentDTO::getId).boxed().collect(Collectors.toList());
        List<StudentOnYear> studentOnYears = this.studentOnYearRepository.findAllByStudentIdIn(studentIdsDTO);
        return StudentOnYearMapper.map(studentDTOS, studentOnYears);

    }


    // Return students on particular subject
    @Override
    public List<StudentOnYearDTO> studentsBySubject(Long subjectId, Pageable pageable)
    throws SubjectRealizationNotFoundException
    {
        SubjectRealization subjectRealization = this.subjectRealizationRepository
                .findBySubjectId(subjectId)
                .orElseThrow(
                        () ->
                                new SubjectRealizationNotFoundException(String.format("Subject realization with subject id: %s could not be found", subjectId))
                            );
        // holds students
        List<SubjectAttendance> subjectAttendances = this.subjectAttendanceRepository
                .getAllBySubjectRealizationIdAndDeletedFalse(subjectRealization.getId(), pageable);

        List<Long> studentIds = new ArrayList<>();
        subjectAttendances.forEach(sA -> studentIds.add(sA.getStudent().getStudentId()));

        List<StudentDTO> studentDTOS = this.authService.getAllStudents(jwtUtil.getToken(), studentIds);

        List<Long> studentIdsDTO = studentDTOS.stream().mapToLong(StudentDTO::getId).boxed().collect(Collectors.toList());
        List<StudentOnYear> studentOnYears = this.studentOnYearRepository.findAllByStudentIdIn(studentIdsDTO);
        return StudentOnYearMapper.map(studentDTOS, studentOnYears, subjectRealization);
    }
    

}
