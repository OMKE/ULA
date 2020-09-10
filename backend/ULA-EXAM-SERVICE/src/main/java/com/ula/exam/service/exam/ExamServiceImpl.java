package com.ula.exam.service.exam;

import com.ula.exam.api.v1.request.UpdateExamEntryRequest;
import com.ula.exam.api.v1.request.UpdateExamRequest;
import com.ula.exam.domain.model.*;
import com.ula.exam.domain.repository.*;
import com.ula.exam.dto.model.ExamDTO;
import com.ula.exam.dto.model.TakingExamDTO;
import com.ula.exam.mapper.ExamMapper;
import com.ula.exam.service.exception.*;
import com.ula.exam.service.takingexam.TakingExamService;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService
{

    @Autowired
    private TakingExamService takingExamService;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExamTypeRepository examTypeRepository;

    @Autowired
    private TakingExamRepository takingExamRepository;

    @Autowired
    private ExamEntryRepository examEntryRepository;

    @Autowired
    private ExamTermRepository examTermRepository;

    @Autowired
    private ExamOutcomeRepository examOutcomeRepository;

    @Override
    public List<ExamDTO> index()
    {
        return ExamMapper.map(this.examRepository.findAll());
    }

    @Override
    public ExamDTO show(Long id)
    throws ExamNotFoundException
    {
        return ExamMapper.map
                (
                    this.examRepository
                            .findById(id)
                            .orElseThrow(() -> new ExamNotFoundException(String.format("Exam with id: %s could not be found", id)))
                );
    }

    @Override
    public ExamDTO showByStudentIdAndSubjectAttendanceId
    (
            Long studentId,
            Long subjectAttendanceId,
            Long id
    )
    throws TakingExamNotFoundException, ExamNotFoundException
    {
        TakingExamDTO takingExamDTO = takingExamService.showByStudentIdAndSubjectAttendanceId(studentId, subjectAttendanceId);
        if(takingExamDTO != null)
        {
            Exam exam = this.examRepository
                    .findById(id)
                    .orElseThrow(() ->
                             new ExamNotFoundException(String.format("Exam with id: %s could not be found", id)));
            // Check if user can access this exam
            // Resource Ownership check
            // Every exam has an id of taking exam, every taking exam is mapped to SubjectAttendance, so if we got TakingExamDTO from
            // TakingExamService (which already checks for resource ownership), we can check if Exam that we found in db belongs to that user
            if(exam.getTakingExam()
                   .getId()
                   .equals(takingExamDTO.getId()))
            {
                return ExamMapper.map(exam);
            } else {
                return null;
            }

        } else {
            return null;
        }
    }

    @Override
    public boolean checkIfValidForEntry(Date examDate)
    {
        // Current time
        DateTime currentDate = DateTime.now();
        DateTime examDateOrg = new DateTime(examDate);

        int days = Days.daysBetween(currentDate, examDateOrg).getDays();

        return days >= 10;
    }

    @Override
    public String store(ExamDTO examDTO)
    throws TakingExamNotFoundException, ExamTypeNotFoundException, ExamTermNotFoundException
    {
        // Check if TakingExam exists
        TakingExam takingExam = this.takingExamRepository
                .findById(examDTO.getTakingExamId())
                .orElseThrow(() -> new TakingExamNotFoundException(String.format("Taking exam with id: %s could not be found", examDTO.getTakingExamId())));
        // Check if ExamType exists
        ExamType examType = this.examTypeRepository
                    .findById(examDTO.getExamTypeId())
                    .orElseThrow(() -> new ExamTypeNotFoundException(String.format("Taking exam with id: %s could not be found", examDTO.getExamTypeId())));


        ExamTerm examTerm = this.examTermRepository
                    .findById(examDTO.getExamTermId())
                    .orElseThrow(() -> new ExamTermNotFoundException(String.format("Exam term with id: %s could not be found", examDTO.getExamTermId())));
        // Populate new Exam
        Exam exam = new Exam()
                .setTakingExam(takingExam)
                .setType(examType)
                .setStartTime(examDTO.getStartTime())
                .setEndTime(examDTO.getEndTime())
                .setFinalExam(examDTO.isFinalExam());



        // Save to DB
        this.examRepository.save(exam);
        this.examEntryRepository.save
                (
                        new ExamEntry()
                                .setActive(false)
                                .setExam(exam)
                                .setExamTerm(examTerm)
                );
        this.examOutcomeRepository.save(new ExamOutcome().setExam(exam).setDescription("Not yet taken."));

        return "Exam has been stored";
    }

    @Override
    public String storeEntry
    (
            Long id,
            Long studentId,
            Long subjectAttendanceId,
            UpdateExamEntryRequest updateExamEntryRequest
    )
    throws ExamNotFoundException, TakingExamNotFoundException
    {
        try {
            ExamDTO examDTO = this.showByStudentIdAndSubjectAttendanceId(studentId, subjectAttendanceId, id);
            Optional<Exam> exam = this.examRepository.findById(examDTO.getId());

            // Check if date is valid
            if(this.checkIfValidForEntry(exam.get().getStartTime()))
            {
                exam.get().getExamEntry().setActive(updateExamEntryRequest.isActive());
                this.examEntryRepository.save(exam.get().getExamEntry());
                return "Exam entry has been placed";
            }
            return "Exam entry has not been placed because it passed more than 10 days before the exam";

        } catch (TakingExamNotFoundException e) {
            throw new TakingExamNotFoundException("Taking exam could not be found");
        }

    }


    @Override
    public String update(Long id, UpdateExamRequest updateExamRequest)
    throws ExamNotFoundException, ExamDoesNotHaveActiveEntryException, ExamDoesNotHaveEntry
    {

        // Find exam with id
        Exam exam = this.examRepository
                .findById(id)
                .orElseThrow(() -> new ExamNotFoundException(String.format("Exam with id: %s could not be found", id)));

        if(exam.getExamEntry() != null)
        {
            if(exam.getExamEntry().isActive())
            {
                exam.setPoints(updateExamRequest.getPoints())
                    .getExamOutcome().setDescription(updateExamRequest.getDescription());

                this.examRepository.save(exam);

                return "Exam has been updated";
            } else {
                throw new ExamDoesNotHaveActiveEntryException("Exam can not be updated because it doesn't have an active entry registered");
            }

        } else {
            throw new ExamDoesNotHaveEntry("Exam can not be updated because exam does not have an entry");
        }
    }

    @Override
    public String delete(Long id)
    throws ExamNotFoundException
    {
        // Find exam with id
        Exam exam = this.examRepository
                .findById(id)
                .orElseThrow(() -> new ExamNotFoundException(String.format("Exam with id: %s could not be found", id)));

        this.examRepository.deleteById(id);

        return "Exam has been deleted";
    }
}
