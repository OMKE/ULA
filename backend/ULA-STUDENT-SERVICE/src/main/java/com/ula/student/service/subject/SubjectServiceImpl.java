package com.ula.student.service.subject;

import com.ula.student.dto.StudentDTO;
import com.ula.student.dto.SubjectAttendanceWithSubjectDTO;

import com.ula.student.feign.FacultyService;
import com.ula.student.service.student.StudentService;
import com.ula.student.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService
{

    @Autowired
    private StudentService studentService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private UserUtil userUtil;


    @Override
    public List<SubjectAttendanceWithSubjectDTO> index()
    {
        StudentDTO studentDTO = this.studentService.getStudent(this.userUtil.getUsername());
        if(studentDTO != null)
        {
            return this.facultyService.getAllSubjectAttendancesWithSubjects(userUtil.getToken(), studentDTO.getStudentOnYear().getId());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<SubjectAttendanceWithSubjectDTO> indexPassed()
    {
        StudentDTO studentDTO = this.studentService.getStudent(this.userUtil.getUsername());
        if(studentDTO != null)
        {
            return this.facultyService.getPassedSubjectAttendancesWithSubjects(userUtil.getToken(), studentDTO.getStudentOnYear().getId());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<SubjectAttendanceWithSubjectDTO> indexNotPassed()
    {
        StudentDTO studentDTO = this.studentService.getStudent(this.userUtil.getUsername());
        if(studentDTO != null)
        {
            return this.facultyService.getNotPassedSubjectAttendancesWithSubjects(userUtil.getToken(), studentDTO.getStudentOnYear().getId());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public SubjectAttendanceWithSubjectDTO show(Long id)
    {
        StudentDTO studentDTO = this.studentService.getStudent(this.userUtil.getUsername());
        if(studentDTO != null)
        {
            return this.facultyService.getSubjectAttendanceById(this.userUtil.getToken(), studentDTO.getStudentOnYear().getId(), id);
        }
        return null;
    }
}
