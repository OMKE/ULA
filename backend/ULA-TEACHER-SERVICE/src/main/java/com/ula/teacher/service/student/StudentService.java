package com.ula.teacher.service.student;

import com.ula.teacher.dto.StudentOnYearDTO;
import com.ula.teacher.service.exception.StudentOnYearNotFoundException;
import com.ula.teacher.service.exception.TeacherNotFoundException;
import org.springframework.data.domain.Pageable;
import org.ula.core.api.response.Response;

import java.util.List;

public interface StudentService
{
    List<StudentOnYearDTO> index(Pageable pageable)
    throws TeacherNotFoundException;
    List<StudentOnYearDTO> getStudentsBySubjectId(Long subjectId, Pageable pageable);
    StudentOnYearDTO show(Long studentId)
    throws StudentOnYearNotFoundException;

    Response<Object> search(String searchParam);
}
