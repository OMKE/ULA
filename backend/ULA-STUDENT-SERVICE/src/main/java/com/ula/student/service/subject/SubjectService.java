package com.ula.student.service.subject;


import com.ula.student.dto.SubjectAttendanceWithSubjectDTO;

import java.util.List;

public interface SubjectService
{
    List<SubjectAttendanceWithSubjectDTO> index();
    List<SubjectAttendanceWithSubjectDTO> indexPassed();
    List<SubjectAttendanceWithSubjectDTO> indexNotPassed();

    SubjectAttendanceWithSubjectDTO show(Long id);

}
