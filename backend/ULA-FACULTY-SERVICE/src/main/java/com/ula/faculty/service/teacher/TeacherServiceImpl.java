package com.ula.faculty.service.teacher;

import com.ula.faculty.domain.model.SubjectAttendance;
import com.ula.faculty.domain.model.SubjectRealization;
import com.ula.faculty.domain.model.TeacherOnRealization;
import com.ula.faculty.domain.model.TeacherSubjectRealization;
import com.ula.faculty.domain.repository.*;
import com.ula.faculty.dto.model.StudentDTO;
import com.ula.faculty.dto.model.SubjectWithRealizationIdDTO;
import com.ula.faculty.feign.AuthServiceFeignClient;
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
    private JWTUtil jwtUtil;

    @Autowired
    private StudentOnYearRepository studentOnYearRepository;

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
