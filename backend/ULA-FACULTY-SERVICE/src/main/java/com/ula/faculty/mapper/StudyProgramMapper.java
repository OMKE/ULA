package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.StudyProgram;
import com.ula.faculty.dto.model.StudyProgramDTO;
import com.ula.faculty.dto.model.StudyProgramDegreeDTO;
import com.ula.faculty.dto.model.StudyProgramLocationDTO;
import com.ula.faculty.dto.model.StudyProgramManagerDTO;
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
                .setDescription(studyProgram.getDescription())
                .setLocation
                        (
                                new StudyProgramLocationDTO().setName(studyProgram.getLocation().getName())
                        )
                .setFacultyId(studyProgram.getFaculty().getId())
                .setDegree(new StudyProgramDegreeDTO().setLevel(studyProgram.getDegree().getLevel()))
                .setId(studyProgram.getId())
                .setManager(
                        new StudyProgramManagerDTO()
                            .setId(studyProgram.getManager().getId())
                            .setEmail(studyProgram.getManager().getEmail())
                            .setFirstName(studyProgram.getManager().getFirstName())
                            .setLastName(studyProgram.getManager().getLastName())
                            .setPhoneNumber(studyProgram.getManager().getPhoneNumber())
                            .setStudyProgramId(studyProgram.getId())
                            .setTitle(studyProgram.getManager().getTitle())
                           );
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
