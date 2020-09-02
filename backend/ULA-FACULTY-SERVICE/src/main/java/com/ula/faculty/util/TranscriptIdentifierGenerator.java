package com.ula.faculty.util;

import com.ula.faculty.domain.repository.StudentOnYearRepository;
import com.ula.faculty.service.exception.StudentOnYearNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class TranscriptIdentifierGenerator
{

    @Autowired
    private StudentOnYearRepository studentOnYearRepository;




    public String generate(Long studyProgramId, Long studentId, Long yearOfStudyId)
    throws StudentOnYearNotFoundException
    {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear) + (studyProgramId + 100) + studentId + yearOfStudyId;
    }
}
