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

    public static boolean check(Long teacherId, Set<TeacherSubjectRealization> teacherSubjectRealizations)
    {
        boolean valid = false;

        for(TeacherSubjectRealization tSR: teacherSubjectRealizations)
        {
            if(tSR.getTeacherOnRealization().getTeacherId().equals(teacherId))
            {
                System.out.println("TeacherOnRealization.getTeacherId: " + tSR.getTeacherOnRealization().getTeacherId() + ", teacherID:" + teacherId);
                valid = true;
            }
        }
        return valid;
    }
}
