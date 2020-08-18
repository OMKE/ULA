package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.Faculty;
import com.ula.faculty.domain.model.StudyProgram;
import com.ula.faculty.dto.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FacultyMapper
{
    public static FacultyDTO mapWithoutStudyProgramsAndInformation(Faculty faculty)
    {
        return new FacultyDTO()
                .setId(faculty.getId())
                .setCampusId(faculty.getCampusId())
                .setIcon(faculty.getIcon())
                .setName(faculty.getName());
    }
    public static  FacultyDTO mapWithStudyProgramsAndInformation(Faculty faculty)
    {
        return new FacultyDTO()
                    .setId(faculty.getId())
                    .setName(faculty.getName())
                    .setCampusId(faculty.getCampusId())
                    .setIcon(faculty.getIcon())
                    .setInformation(FacultyMapper.mapFacultyInformation(faculty))
                    .setStudyPrograms(FacultyMapper.mapStudyPrograms(faculty));

    }



    public static ArrayList<FacultyDTO> mapFacultiesWithoutStudyProgramsAndInformation(List<Faculty> faculties)
    {
        ArrayList<FacultyDTO> facultyDTOS = new ArrayList<>();
        for(Faculty faculty: faculties)
        {
            facultyDTOS.add(
                    new FacultyDTO()
                        .setId(faculty.getId())
                        .setCampusId(faculty.getCampusId())
                        .setName(faculty.getName())
                        .setIcon(faculty.getIcon())
            );
        }
        return facultyDTOS;
    }

    public static ArrayList<FacultyDTO> mapFacultiesWithStudyPrograms(List<Faculty> faculties)
    {
        ArrayList<FacultyDTO> facultyDTOS = new ArrayList<>();
        for(Faculty faculty: faculties)
        {
            facultyDTOS.add(
                    new FacultyDTO()
                            .setId(faculty.getId())
                            .setCampusId(faculty.getCampusId())
                            .setName(faculty.getName())
                            .setIcon(faculty.getIcon())
                            .setStudyPrograms(FacultyMapper.mapStudyPrograms(faculty))
            );
        }
        return facultyDTOS;
    }

    public static ArrayList<FacultyDTO> mapFacultiesWithStudyProgramsAndInformation(List<Faculty> faculties)
    {
        ArrayList<FacultyDTO> facultyDTOS = new ArrayList<>();
        for(Faculty faculty: faculties)
        {
            facultyDTOS.add(
                    new FacultyDTO()
                            .setId(faculty.getId())
                            .setCampusId(faculty.getCampusId())
                            .setName(faculty.getName())
                            .setIcon(faculty.getIcon())
                            .setStudyPrograms(FacultyMapper.mapStudyPrograms(faculty))
                            .setInformation(FacultyMapper.mapFacultyInformation(faculty))
            );
        }
        return facultyDTOS;
    }

    public static HashSet<StudyProgramDTO> mapStudyPrograms(Faculty faculty)
    {
        HashSet<StudyProgramDTO> studyProgramDTOS = new HashSet<>();
        for(StudyProgram studyProgram: faculty.getStudyPrograms())
        {
            studyProgramDTOS.add(
                    new StudyProgramDTO()
                        .setId(studyProgram.getId())
                        .setName(studyProgram.getName())
                        .setDegree(new StudyProgramDegreeDTO().setLevel(studyProgram.getDegree().getLevel()))
                        .setFacultyId(faculty.getId())
                        .setLocation(new StudyProgramLocationDTO().setName(studyProgram.getLocation().getName()))
            );
        }
        return studyProgramDTOS;
    }

    public static FacultyInformationDTO mapFacultyInformation(Faculty faculty)
    {
        return new FacultyInformationDTO()
                    .setId(faculty.getInformation().getId())
                    .setAccreditation(faculty.getInformation().getAccreditation())
                    .setEmail(faculty.getInformation().getEmail())
                    .setFacultyId(faculty.getId())
                    .setHistory(faculty.getInformation().getHistory())
                    .setMission(faculty.getInformation().getMission())
                    .setPresident(faculty.getInformation().getPresident())
                    .setPhoneNumber(faculty.getInformation().getPhoneNumber());
    }
}
