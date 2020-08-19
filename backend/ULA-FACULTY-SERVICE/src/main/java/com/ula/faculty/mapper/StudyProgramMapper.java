package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.StudyProgram;
import com.ula.faculty.dto.model.StudyProgramDTO;
import com.ula.faculty.dto.model.StudyProgramDegreeDTO;
import com.ula.faculty.dto.model.StudyProgramLocationDTO;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudyProgramMapper
{
    /*
        Maps StudyProgram to StudyProgramDTO
    */
    public static StudyProgramDTO map(StudyProgram studyProgram)
    {
        return new StudyProgramDTO()
                    .setName(studyProgram.getName())
                    .setLocation
                            (
                            new StudyProgramLocationDTO().setName(studyProgram.getLocation().getName())
                            )
                    .setFacultyId(studyProgram.getFaculty().getId())
                    .setDegree(new StudyProgramDegreeDTO().setLevel(studyProgram.getDegree().getLevel()))
                    .setId(studyProgram.getId());
    }

    /*
        Maps StudyProgram collection to collection of StudyProgramDTO
    */
    public static ArrayList<StudyProgramDTO> map(Page<StudyProgram> studyPrograms)
    {
        return studyPrograms.stream().map(StudyProgramMapper::map).collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<StudyProgramDTO> map(List<StudyProgram> studyPrograms)
    {
        return studyPrograms.stream().map(StudyProgramMapper::map).collect(Collectors.toCollection(ArrayList::new));
    }

}
