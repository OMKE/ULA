package com.ula.faculty.service.subject;

import com.ula.faculty.dto.model.SubjectDTO;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.YearOfStudyNotFoundException;

import java.util.List;

public interface SubjectService
{
    List<SubjectDTO> index();
    List<SubjectDTO> index(Long yearOfStudyId) throws YearOfStudyNotFoundException;
    SubjectDTO show(Long id) throws SubjectNotFoundException;
    String store(SubjectDTO subjectDTO)
    throws YearOfStudyNotFoundException;
    String update(Long id, SubjectDTO subjectDTO)
    throws SubjectNotFoundException, YearOfStudyNotFoundException;
    String delete(Long id)
    throws SubjectNotFoundException;
}
