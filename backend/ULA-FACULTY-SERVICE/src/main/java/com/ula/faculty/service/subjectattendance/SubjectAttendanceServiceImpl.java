package com.ula.faculty.service.subjectattendance;

import com.ula.faculty.domain.model.StudentOnYear;
import com.ula.faculty.domain.model.SubjectAttendance;
import com.ula.faculty.domain.model.SubjectRealization;
import com.ula.faculty.domain.repository.StudentOnYearRepository;
import com.ula.faculty.domain.repository.SubjectAttendanceRepository;
import com.ula.faculty.domain.repository.SubjectRealizationRepository;
import com.ula.faculty.dto.model.SubjectAttendanceDTO;
import com.ula.faculty.dto.model.SubjectAttendanceWithSubjectDTO;
import com.ula.faculty.dto.request.StoreTakingExamRequest;
import com.ula.faculty.feign.ExamFeignClient;
import com.ula.faculty.mapper.SubjectAttendanceMapper;
import com.ula.faculty.mapper.SubjectAttendanceWithSubjectMapper;
import com.ula.faculty.service.exception.StudentNotFoundException;
import com.ula.faculty.service.exception.StudentOnYearNotFoundException;
import com.ula.faculty.service.exception.SubjectAttendanceNotFoundException;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.feign.AuthServiceFeignClient;

import java.util.List;

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
        // Call exam service and create TakingExam
        this.examFeignClient.storeTakingExam(new StoreTakingExamRequest().setNote(note).setSubjectAttendanceId(subjectAttendance.getId()), token);

        return "Subject attendance has been stored";
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
    public String delete(Long id)
    {
        return null;
    }
}
