package com.ula.faculty.service.subjectsyllabus;

import com.ula.faculty.api.v1.request.UpdateSubjectSyllabusRequest;
import com.ula.faculty.domain.guard.SubjectRealizationTeacherGuard;
import com.ula.faculty.domain.model.Subject;
import com.ula.faculty.domain.model.SubjectSyllabus;
import com.ula.faculty.domain.model.TeacherOnRealization;
import com.ula.faculty.domain.repository.SubjectRepository;
import com.ula.faculty.domain.repository.SubjectSyllabusRepository;
import com.ula.faculty.domain.repository.TeacherOnRealizationRepository;
import com.ula.faculty.service.exception.SubjectNotFoundException;
import com.ula.faculty.service.exception.SubjectSyllabusNotFoundException;
import com.ula.faculty.service.exception.TeacherOnRealizationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ula.core.exception.NotAuthorizedException;

@Service
public class SubjectSyllabusServiceImpl implements SubjectSyllabusService
{

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private SubjectSyllabusRepository subjectSyllabusRepository;

    @Autowired
    private TeacherOnRealizationRepository teacherOnRealizationRepository;

    @Override
    public boolean update(Long id, Long teacherId, UpdateSubjectSyllabusRequest request)
    throws SubjectNotFoundException, SubjectSyllabusNotFoundException, NotAuthorizedException, TeacherOnRealizationNotFoundException
    {
        TeacherOnRealization teacherOnRealization = this.teacherOnRealizationRepository
                .findByTeacherId(teacherId)
                .orElseThrow(() -> new TeacherOnRealizationNotFoundException(
                        String.format("Teacher on realization with id: %s could not be found", teacherId)));

        SubjectSyllabus subjectSyllabus = this.subjectSyllabusRepository
                .findById(id)
                .orElseThrow(() -> new SubjectSyllabusNotFoundException
                                     (
                                             String.format("Subject syllabus with id: %s could not be found", id)
                                     )
                            );
        Subject subject = subjectSyllabus.getSubject();
        if(subject == null)
        {
            throw new SubjectNotFoundException("Subject not found on subject syllabus");
        }

        if(SubjectRealizationTeacherGuard.check(teacherOnRealization.getId(), subject.getSubjectRealization().getTeachersOnRealization()))
        {

            subjectSyllabus.setContent(request.getContent());
            this.subjectSyllabusRepository.save(subjectSyllabus);
            return true;
        } else {
            throw new NotAuthorizedException(String.format("Teacher with id: %s is not authorized for provided subject", teacherId));
        }
    }
}
