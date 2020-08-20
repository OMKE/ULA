package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.YearOfStudy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YearOfStudyRepository extends CrudRepository<YearOfStudy, Long>
{
    List<YearOfStudy> findAllByStudyProgramId(Long studyProgramId);
}
