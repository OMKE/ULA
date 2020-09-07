package com.ula.exam.service.points;

import com.ula.exam.domain.model.Exam;
import com.ula.exam.domain.model.TakingExam;
import com.ula.exam.domain.repository.ExamRepository;
import com.ula.exam.domain.repository.TakingExamRepository;
import com.ula.exam.dto.model.ExamDTO;
import com.ula.exam.dto.model.PointsDTO;
import com.ula.exam.mapper.ExamMapper;
import com.ula.exam.service.exception.FinalExamNotFoundException;
import com.ula.exam.service.exception.TakingExamNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PointsServiceImpl implements PointsService
{

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private TakingExamRepository takingExamRepository;

    @Override
    public PointsDTO getByTakingExamId(Long takingExamId)
    throws TakingExamNotFoundException
    {

        TakingExam takingExam = this.takingExamRepository
                .findById(takingExamId)
                .orElseThrow(() -> new TakingExamNotFoundException(String.format("Taking exam with id: %s could not be found", takingExamId)));

        // get last two
        List<Exam> lastTwo = this.examRepository.findTop2ByTakingExamIdAndFinalExamFalseOrderByEndTimeDesc(takingExamId);

        // get last which is final
        Optional<Exam> lastFinal = this.examRepository
                .findTopByTakingExamIdAndFinalExamTrueOrderByEndTimeDesc(takingExamId);


        return this.map(takingExam, lastTwo, lastFinal);
    }

    @Override
    public PointsDTO getBySubjectAttendanceId(Long subjectAttendanceId)
    throws TakingExamNotFoundException, FinalExamNotFoundException
    {
        TakingExam takingExam = this.takingExamRepository
                .getBySubjectAttendanceId(subjectAttendanceId)
                .orElseThrow(() -> new TakingExamNotFoundException
                                (
                                    String.format("Taking exam with subject attendance id: %s could not be found", subjectAttendanceId)
                                )
                            );

        // get last two
        List<Exam> lastTwo = this.examRepository.findTop2ByTakingExamIdAndFinalExamFalseOrderByEndTimeDesc(takingExam.getId());

        // get last which is final
        Optional<Exam> lastFinal = this.examRepository
                .findTopByTakingExamIdAndFinalExamTrueOrderByEndTimeDesc(takingExam.getId());


        return this.map(takingExam, lastTwo, lastFinal);

    }

    private PointsDTO map(TakingExam takingExam, List<Exam> lastTwo, Optional<Exam> lastFinal)
    {
        // Create an array so we can return exams that are used for calculating
        List<ExamDTO> exams = new ArrayList<ExamDTO>();
        lastTwo.forEach(exam -> exams.add(ExamMapper.map(exam)));
        // hasFinal - if student has only taken two exams without final, we will notify the user that he doesn't have final exam
        boolean hasFinal = false;

        // sum points only if exam has more than 15 points
        // 15 or more points is minimal value for exam to be considered as passed
        double points = lastTwo.stream()
                               .map(exam -> exam.getPoints() >= 15 ? exam.getPoints(): 0)
                               .mapToDouble(Double::doubleValue)
                               .sum();

        if(lastFinal.isPresent())
        {
            points += lastFinal.get().getPoints();
            exams.add(ExamMapper.map(lastFinal.get()));
            hasFinal = true;
        }




        // create PointsDTO
        PointsDTO pointsDTO = new PointsDTO()
                .setSubject(takingExam.getNote())
                .setHasFinal(hasFinal)
                .setPoints(points)
                .setSubjectAttendanceId(takingExam.getSubjectAttendanceId())
                .setTakingExamId(takingExam.getId())
                .setExams(exams);

        return pointsDTO;
    }
}
