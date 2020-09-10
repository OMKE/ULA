package com.ula.faculty.service.subjectattendance;

import com.ula.faculty.dto.model.SubjectAttendanceDTO;
import com.ula.faculty.dto.model.SubjectAttendanceWithSubjectDTO;
import com.ula.faculty.service.exception.StudentNotFoundException;
import com.ula.faculty.service.exception.StudentOnYearNotFoundException;
import com.ula.faculty.service.exception.SubjectAttendanceNotFoundException;
import com.ula.faculty.service.exception.SubjectRealizationNotFoundException;

import java.util.List;

public interface SubjectAttendanceService
{
    List<SubjectAttendanceDTO> index();

    SubjectAttendanceDTO show(Long id)
    throws SubjectAttendanceNotFoundException;

    String store(SubjectAttendanceDTO subjectAttendanceDTO, String token)
    throws SubjectRealizationNotFoundException, StudentNotFoundException, StudentOnYearNotFoundException;

    String update(Long id, SubjectAttendanceDTO subjectAttendanceDTO)
    throws SubjectRealizationNotFoundException, StudentOnYearNotFoundException, SubjectAttendanceNotFoundException;

    String delete(Long id);


    //  For Student service
    List<SubjectAttendanceWithSubjectDTO> getAllByStudentId(Long studentId);
    List<SubjectAttendanceWithSubjectDTO> getAllPassedByStudentId(Long studentId);
    List<SubjectAttendanceWithSubjectDTO> getAllCurrentByStudentId(Long studentId);
    SubjectAttendanceWithSubjectDTO getOneByStudentId(Long resourceId, Long studentId)
    throws SubjectAttendanceNotFoundException;

    List<SubjectAttendanceWithSubjectDTO> getAllBySubjectRealizationIdAndStudentId(Long subjectRealizationId, Long studentId);

}
