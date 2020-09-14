package com.ula.faculty.domain.guard;

import com.ula.faculty.domain.model.TeacherSubjectRealization;

import java.util.Set;

public class SubjectRealizationTeacherGuard
{
    public static boolean check(Set<TeacherSubjectRealization> teacherSubjectRealizations, Long subjectRealizationId)
    {
        boolean valid = false;
        for(TeacherSubjectRealization tSR: teacherSubjectRealizations)
        {
            if(tSR.getSubjectRealization().getId().equals(subjectRealizationId))
            {
                valid = true;
            }
        }
        return valid;
    }
}
