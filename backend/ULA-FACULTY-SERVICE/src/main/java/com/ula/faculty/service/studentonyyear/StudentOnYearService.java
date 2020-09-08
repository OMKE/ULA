package com.ula.faculty.service.studentonyyear;

import com.ula.faculty.api.v1.request.StoreStudentOnYearRequest;
import com.ula.faculty.api.v1.request.UpdateStudentOnYearRequest;
import com.ula.faculty.domain.model.Subject;
import com.ula.faculty.dto.model.StudentOnYearDTO;
import com.ula.faculty.service.exception.*;

import java.util.List;
import java.util.Set;

public interface StudentOnYearService
{
    List<StudentOnYearDTO> index();

    StudentOnYearDTO show(Long id)
    throws StudentOnYearNotFoundException;

    StudentOnYearDTO showByStudentId(Long studentId)
    throws StudentOnYearNotFoundException;

    String store(String token, StoreStudentOnYearRequest studentOnYearDTO)
    throws StudentOnYearNotFoundException, StudentNotFoundException, YearOfStudyNotFoundException, StudentOnYearConflictException, SubjectRealizationNotFoundException;

    void storeSubjectAttendanceBasedOnSubjects(Set<Subject> subjects, Long studentId, String token)
    throws SubjectRealizationNotFoundException, StudentNotFoundException, StudentOnYearNotFoundException;

    String addYearOfStudy(Long id, UpdateStudentOnYearRequest studentOnYearDTO, String token)
    throws StudentNotFoundException, YearOfStudyNotFoundException, StudentOnYearConflictException, StudentOnYearNotFoundException, SubjectRealizationNotFoundException;

    String delete(Long id)
    throws StudentOnYearNotFoundException;
}
