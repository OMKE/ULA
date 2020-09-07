package com.ula.exam.domain.repository;

import com.ula.exam.domain.model.Exam;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends CrudRepository<Exam, Long>
{


    List<Exam> findAllByTakingExamId(Long takingExamId);

    //    @TODO - Limit to TWO ROWS ONLY
    List<Exam> findTop2ByTakingExamIdAndFinalExamFalseOrderByEndTimeDesc(Long takingExamId);
    //    @TODO - Limit to ONE

    Optional<Exam> findTopByTakingExamIdAndFinalExamTrueOrderByEndTimeDesc(Long takingExamId);
}
