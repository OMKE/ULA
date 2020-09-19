package com.ula.faculty.service.subjectattendance;

import com.ula.faculty.domain.model.Subject;
import com.ula.faculty.domain.model.SubjectAttendance;
import com.ula.faculty.dto.model.SubjectAttendanceDTO;
import com.ula.faculty.dto.model.SubjectAttendanceWithSubjectDTO;
import com.ula.faculty.service.exception.*;
import org.ula.core.exception.NotAuthorizedException;

import java.util.List;
import java.util.Set;

public interface SubjectAttendanceService
{
    List<SubjectAttendanceDTO> index();

    SubjectAttendanceDTO show(Long id)
    throws SubjectAttendanceNotFoundException;

    String store(SubjectAttendanceDTO subjectAttendanceDTO, String token)
    throws SubjectRealizationNotFoundException, StudentNotFoundException, StudentOnYearNotFoundException;

    Set<SubjectAttendance> storeMany(Set<Subject> subjects, Long studentId)
    throws StudentOnYearNotFoundException;

    String update(Long id, SubjectAttendanceDTO subjectAttendanceDTO)
    throws SubjectRealizationNotFoundException, StudentOnYearNotFoundException, SubjectAttendanceNotFoundException;

    String delete(Long id);

    List<Long> getIdsBySubjectId(Long teacherId, Long subjectId)
    throws SubjectRealizationNotFoundException, TeacherOnRealizationNotFoundException, NotAuthorizedException;


    //  For Student service
    List<SubjectAttendanceWithSubjectDTO> getAllByStudentId(Long studentId);
    List<SubjectAttendanceWithSubjectDTO> getAllPassedByStudentId(Long studentId);
    List<SubjectAttendanceWithSubjectDTO> getAllCurrentByStudentId(Long studentId);
    SubjectAttendanceWithSubjectDTO getOneByStudentId(Long resourceId, Long studentId)
    throws SubjectAttendanceNotFoundException;

    List<SubjectAttendanceWithSubjectDTO> getAllBySubjectRealizationIdAndStudentId(Long subjectRealizationId, Long studentId);

    SubjectAttendanceDTO getBySubjectIdAndStudentId(Long subjectId, Long studentId)
    throws SubjectRealizationNotFoundException, StudentOnYearNotFoundException, SubjectAttendanceNotFoundException;

}
