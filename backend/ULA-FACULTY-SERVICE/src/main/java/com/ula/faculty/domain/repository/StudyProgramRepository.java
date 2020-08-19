package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.StudyProgram;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudyProgramRepository extends CrudRepository<StudyProgram, Long>
{
    Page<StudyProgram> findAllByFacultyId(Long facultyId, Pageable pageable);
    List<StudyProgram> findStudyProgramByNameContains(String name);
}
