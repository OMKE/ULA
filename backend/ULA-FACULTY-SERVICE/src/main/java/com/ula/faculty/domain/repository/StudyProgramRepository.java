package com.ula.faculty.domain.repository;

import com.ula.faculty.domain.model.StudyProgram;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.List;

@Repository
public interface StudyProgramRepository extends CrudRepository<StudyProgram, Long>
{
    @Query("select e from StudyProgram e where e.faculty.id=?1 and e.deleted=false")
    Page<StudyProgram> findAllByFacultyId(Long facultyId, Pageable pageable);

    @Query("select e from StudyProgram e where e.name like %:name% and e.deleted=false")
    List<StudyProgram> findStudyProgramByNameContains(@Param("name") String name);
}
