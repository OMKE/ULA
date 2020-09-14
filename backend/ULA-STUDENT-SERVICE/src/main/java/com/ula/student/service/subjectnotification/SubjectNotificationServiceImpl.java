package com.ula.student.service.subjectnotification;

import com.ula.student.dto.StudentDTO;
import com.ula.student.dto.SubjectAttendanceWithSubjectDTO;
import com.ula.student.dto.SubjectNotificationDTO;
import com.ula.student.feign.FacultyService;
import com.ula.student.service.exception.SubjectAttendanceWithSubjectDTONotFoundException;
import com.ula.student.service.student.StudentService;
import com.ula.student.service.subject.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.ula.core.util.JWTUtil;

import java.util.List;

@Service
public class SubjectNotificationServiceImpl implements SubjectNotificationService
{

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private SubjectService subjectService;

    @Override
    public List<SubjectNotificationDTO> index(Pageable pageable)
    {

        StudentDTO studentDTO = this.studentService.getStudent(this.jwtUtil.getUsername());
        if(studentDTO != null)
        {
            return facultyService.getNotifications(
                    jwtUtil.getToken(), studentDTO.getId(), pageable
                                                  );
        } else {
            return null;
        }


    }

    @Override
    public List<SubjectNotificationDTO> indexBySubjectId(Long subjectId, Pageable pageable)
    throws SubjectAttendanceWithSubjectDTONotFoundException
    {
        SubjectAttendanceWithSubjectDTO subjectDTO = this.subjectService.show(subjectId);
        if(subjectDTO != null)
        {

            return this.facultyService
                    .getNotificationsBySubjectId(this.jwtUtil.getUsername(), subjectDTO.getSubject().getId(), pageable);

        } else {
            throw new SubjectAttendanceWithSubjectDTONotFoundException(
                    String.format("Subject attendance with subject id: %s could not be found in faculty service", subjectId)
            );
        }
    }

}
