package com.ula.faculty.service.teacheronrealization;

import com.ula.faculty.domain.model.TeacherDTO;
import com.ula.faculty.domain.model.TeacherOnRealization;
import com.ula.faculty.domain.repository.TeacherOnRealizationRepository;
import com.ula.faculty.dto.model.TeacherOnRealizationDTO;
import com.ula.faculty.feign.AuthServiceFeignClient;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.util.JWTUtil;


@Service
public class TeacherOnRealizationServiceImpl implements TeacherOnRealizationService
{

    @Autowired
    private TeacherOnRealizationRepository teacherOnRealizationRepository;


    @Autowired
    private AuthServiceFeignClient authService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public TeacherOnRealizationDTO getLoggedInTeacherOnRealization()
    throws TeacherOnRealizationNotFoundException
    {
        TeacherDTO teacherDTO = this.authService.getTeacher(jwtUtil.getToken());
        TeacherOnRealization teacherOnRealization = this.teacherOnRealizationRepository
                .findByTeacherId(teacherDTO.getId())
                .orElseThrow(() -> new TeacherOnRealizationNotFoundException
                        (String.format("Teacher on realization with teacher id: %s could not be found", teacherDTO.getId())));

        return new TeacherOnRealizationDTO()
                    .setId(teacherOnRealization.getId())
                    .setTeacherId(teacherOnRealization.getTeacherId())
                    .setNumberOfLectures(teacherOnRealization.getNumberOfLectures());
    }
}
