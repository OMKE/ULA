package com.ula.student.service.yearofstudy;

import com.ula.student.dto.StudentDTO;
import com.ula.student.dto.YearOfStudyDTO;
import com.ula.student.mapper.YearOfStudyMapper;
import com.ula.student.service.exception.YearOfStudyNotFoundException;
import com.ula.student.service.student.StudentService;
import com.ula.student.service.subject.SubjectService;
import com.ula.student.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class YearOfStudyServiceImpl implements YearOfStudyService
{
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;


    @Autowired
    private UserUtil userUtil;

    @Override
    public List<YearOfStudyDTO> index()
    {
        StudentDTO studentDTO = this.studentService.getStudent(this.userUtil.getUsername());
        List<YearOfStudyDTO> years = new ArrayList<>();

        if(studentDTO != null)
        {
            for(Long id: studentDTO.getStudentOnYear().getYearOfStudyIds())
            {
                try {
                    years.add(this.show(id));
                } catch (YearOfStudyNotFoundException e) { }
            }
            years.sort(Comparator.comparingLong(YearOfStudyDTO::getId));
            return years;
        } else {
            return years;
        }

    }

    @Override
    public YearOfStudyDTO show(Long id)
    throws YearOfStudyNotFoundException
    {

        StudentDTO studentDTO = this.studentService.getStudent(this.userUtil.getUsername());
        if (studentDTO.getStudentOnYear().getYearOfStudyIds().contains(id))
        {
            return YearOfStudyMapper.map(this.subjectService.index(), id);
        } else
        {
            throw new YearOfStudyNotFoundException(String.format("Student doesn't have a year of study with id: %s ", id));
        }
    }
}
