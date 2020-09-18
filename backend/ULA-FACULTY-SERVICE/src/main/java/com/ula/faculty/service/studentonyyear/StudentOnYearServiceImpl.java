package com.ula.faculty.service.studentonyyear;

import com.ula.faculty.api.v1.request.StoreStudentOnYearRequest;
import com.ula.faculty.api.v1.request.UpdateStudentOnYearRequest;
import com.ula.faculty.domain.model.*;
import com.ula.faculty.domain.repository.StudentOnYearRepository;
import com.ula.faculty.domain.repository.StudentOnYearYearOfStudyRepository;
import com.ula.faculty.domain.repository.YearOfStudyRepository;
import com.ula.faculty.dto.model.StudentDTO;
import com.ula.faculty.dto.model.StudentOnYearDTO;
import com.ula.faculty.dto.request.StoreTakingExamRequest;
import com.ula.faculty.feign.ExamFeignClient;
import com.ula.faculty.mapper.StudentDTOMapper;
import com.ula.faculty.mapper.StudentOnYearMapper;
import com.ula.faculty.service.exception.*;
import com.ula.faculty.service.subjectattendance.SubjectAttendanceService;
import com.ula.faculty.util.TranscriptIdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.api.response.Response;
import org.ula.core.feign.AuthServiceFeignClient;
import org.ula.core.util.JWTUtil;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentOnYearServiceImpl implements StudentOnYearService
{

    @Autowired
    private StudentOnYearRepository studentOnYearRepository;

    @Autowired
    private YearOfStudyRepository yearOfStudyRepository;

    @Autowired
    private AuthServiceFeignClient authServiceULACORE;

    @Autowired
    private TranscriptIdentifierGenerator transcriptIdentifierGenerator;

    @Autowired
    private SubjectAttendanceService subjectAttendanceService;


    @Autowired
    private ExamFeignClient examService;

    @Autowired
    private JWTUtil jwtUtil;



    @Autowired
    private StudentOnYearYearOfStudyRepository studentOnYearYearOfStudyRepository;

    @Override
    public List<StudentOnYearDTO> index()
    {
        return StudentOnYearMapper.map(studentOnYearRepository.findAll());
    }

    @Override
    public StudentOnYearDTO show(Long id)
    throws StudentOnYearNotFoundException
    {
        return StudentOnYearMapper.map
                (
                        this.studentOnYearRepository.findById(id).orElseThrow
                                (
                                    () -> new StudentOnYearNotFoundException(String.format("Student with id: %s could not be found", id))
                                )
                );
    }

    @Override
    public StudentOnYearDTO showByStudentId(Long studentId)
    throws StudentOnYearNotFoundException
    {
        return StudentOnYearMapper.map
                (
                    this.studentOnYearRepository
                            .findByStudentIdAndDeletedFalse(studentId)
                            .orElseThrow(
                                    () ->
                                    new StudentOnYearNotFoundException
                                            (
                                            String.format("Student on year with student id: %s could not be found", studentId)
                                            )
                                        )
                );

    }

    @Override
    public String store(String token, StoreStudentOnYearRequest studentOnYearDTO)
    throws StudentOnYearNotFoundException, StudentNotFoundException, YearOfStudyNotFoundException, StudentOnYearConflictException, SubjectRealizationNotFoundException
    {

        Response<Object> response = authServiceULACORE.getStudent(studentOnYearDTO.getStudentId(), token);



        if(response.getErrors() != null)
        {
            throw new StudentNotFoundException(response.getErrors().toString());
        }

        YearOfStudy yearOfStudy = this.yearOfStudyRepository
                .findById(studentOnYearDTO.getYearOfStudyId())
                .orElseThrow(() -> new YearOfStudyNotFoundException
                                (
                                    String.format("Year of study with id: %s could not be found", studentOnYearDTO.getYearOfStudyId())
                                )
                            );

        StudentDTO studentDTO = StudentDTOMapper.map(response.getPayload());



        Optional<StudentOnYear> foundedStudent = this.studentOnYearRepository.findByStudentIdAndDeletedFalse(studentDTO.getId());
        if(foundedStudent.isPresent())
        {
            throw new StudentOnYearConflictException
                    (
                        String.format("Student on year with student id: %s already exists",
                                      studentDTO.getId())
                    );
        }

        // Generate transcript identifier based on study program id, student's id and year of study id
        String transcriptIdentifier = transcriptIdentifierGenerator.generate(yearOfStudy.getStudyProgram().getId(), studentDTO.getId(), yearOfStudy.getId());

        StudentOnYear studentOnYear = new StudentOnYear()
                .setStudentId(studentOnYearDTO.getStudentId())
                .setDateOfEnrollment(studentOnYearDTO.getDateOfEnrollment())
                .setTranscriptIdentifier(transcriptIdentifier);
        studentOnYear.setYearOfStudies(new HashSet<>());
        this.studentOnYearRepository.save(studentOnYear);
        studentOnYear.getYearOfStudies().add(new StudentOnYearYearOfStudy().setYearOfStudy(yearOfStudy).setStudentOnYear(studentOnYear));
        this.studentOnYearRepository.save(studentOnYear);
        this.storeSubjectAttendanceBasedOnSubjects(yearOfStudy.getSubjects(), studentOnYear.getId());
        return "Student on year has been stored";

    }

    @Override
    public void storeSubjectAttendanceBasedOnSubjects(Set<Subject> subjects, Long studentId)
    throws SubjectRealizationNotFoundException, StudentNotFoundException, StudentOnYearNotFoundException
    {
        Set<SubjectAttendance> subjectAttendances = this.subjectAttendanceService.storeMany(subjects, studentId);

        List<StoreTakingExamRequest> requests = subjectAttendances
                .stream()
                .map(
                    subjectAttendance ->
                    new StoreTakingExamRequest()
                        .setSubjectAttendanceId(subjectAttendance.getId())
                        .setNote(String.format("Subject: %s", subjectAttendance.getSubjectRealization().getSubject().getName()))
                    )
                .collect(Collectors.toList());
        this.examService.storeManyTakingExam(jwtUtil.getToken(), requests);
    }


    @Override
    public String addYearOfStudy(Long id, UpdateStudentOnYearRequest studentOnYearDTO, String token)
    throws StudentNotFoundException, YearOfStudyNotFoundException, StudentOnYearConflictException, StudentOnYearNotFoundException, SubjectRealizationNotFoundException
    {

        YearOfStudy yearOfStudy = this.yearOfStudyRepository
                .findById(studentOnYearDTO.getYearOfStudyId())
                .orElseThrow(() -> new YearOfStudyNotFoundException
                                     (
                                             String.format("Year of study with id: %s could not be found", studentOnYearDTO.getYearOfStudyId())
                                     )
                            );

        StudentOnYear studentOnYear = this.studentOnYearRepository
                .findById(id)
                .orElseThrow(() -> new StudentOnYearNotFoundException
                                     (
                                             String.format("Student on year with id: %s could not be found", id)
                                     ));


        studentOnYear.getYearOfStudies().add(new StudentOnYearYearOfStudy().setStudentOnYear(studentOnYear).setYearOfStudy(yearOfStudy));
        this.studentOnYearRepository.save(studentOnYear);
        this.storeSubjectAttendanceBasedOnSubjects(yearOfStudy.getSubjects(), studentOnYear.getId());
        return "Student on year has been updated";

    }

    @Override
    public String delete(Long id)
    throws StudentOnYearNotFoundException
    {
        StudentOnYear studentOnYear = this.studentOnYearRepository
                .findById(id)
                .orElseThrow(() -> new StudentOnYearNotFoundException
                        (
                                String.format("Student with id: %s  could not be found",
                                              id)
                        ));
        this.studentOnYearRepository.deleteById(id);
        return String.format("Student on year with id: %s has been deleted", id);
    }
}
