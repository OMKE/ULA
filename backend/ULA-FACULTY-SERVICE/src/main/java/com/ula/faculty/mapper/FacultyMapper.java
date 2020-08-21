package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.Faculty;
import com.ula.faculty.domain.model.StudyProgram;
import com.ula.faculty.dto.model.*;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FacultyMapper
{

    public static FacultyDTO mapWithStudyPrograms(Faculty faculty, Page<StudyProgram> studyPrograms)
    {
        return new FacultyDTO()
                    .setId(faculty.getId())
                    .setIcon(faculty.getIcon())
                    .setCampusId(faculty.getCampusId())
                    .setName(faculty.getName())
                    .setStudyPrograms(
                            studyPrograms.stream().map(studyProgram ->
                                    new StudyProgramDTO()
                                        .setId(studyProgram.getId())
                                        .setName(studyProgram.getName())
                                        .setDegree(
                                                new StudyProgramDegreeDTO()
                                                    .setLevel(studyProgram.getDegree().getLevel())
                                        )
                                        .setFacultyId(faculty.getId())
                                        .setLocation(
                                                new StudyProgramLocationDTO()
                                                    .setName(studyProgram.getLocation().getName())
                                        )
                                    ).collect(Collectors.toSet())
                    );
    }

    public static FacultyDTO mapWithoutStudyProgramsAndInformation(Faculty faculty)
    {
        return new FacultyDTO()
                .setId(faculty.getId())
                .setCampusId(faculty.getCampusId())
                .setIcon(faculty.getIcon())
                .setName(faculty.getName());
    }
    public static FacultyDTO mapWithStudyProgramsAndInformation(Faculty faculty)
    {
        return new FacultyDTO()
                    .setId(faculty.getId())
                    .setName(faculty.getName())
                    .setCampusId(faculty.getCampusId())
                    .setIcon(faculty.getIcon())
                    .setInformation(FacultyMapper.mapFacultyInformation(faculty))
                    .setStudyPrograms(FacultyMapper.mapStudyPrograms(faculty));
    }

    public static FacultyDTO mapWithInformation(Faculty faculty)
    {
        return new FacultyDTO()
                .setId(faculty.getId())
                .setName(faculty.getName())
                .setCampusId(faculty.getCampusId())
                .setIcon(faculty.getIcon())
                .setInformation(FacultyMapper.mapFacultyInformation(faculty));
    }

    public static ArrayList<FacultyDTO> mapFacultiesWithoutStudyProgramsAndInformation(List<Faculty> faculties)
    {
        return faculties.stream().map
                (faculty ->
                    new FacultyDTO()
                            .setId(faculty.getId())
                            .setCampusId(faculty.getCampusId())
                            .setName(faculty.getName())
                            .setIcon(faculty.getIcon())
                ).collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<FacultyDTO> mapFacultiesWithStudyPrograms(List<Faculty> faculties)
    {
        return faculties.stream().map
                (faculty ->
                        new FacultyDTO()
                                .setId(faculty.getId())
                                .setCampusId(faculty.getCampusId())
                                .setName(faculty.getName())
                                .setIcon(faculty.getIcon())
                                .setStudyPrograms(FacultyMapper.mapStudyPrograms(faculty))
                ).collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<FacultyDTO> mapFacultiesWithStudyProgramsAndInformation(List<Faculty> faculties)
    {
        ArrayList<FacultyDTO> facultyDTOS = new ArrayList<>();

        return faculties.stream().map
                (faculty ->
                    new FacultyDTO()
                            .setId(faculty.getId())
                            .setCampusId(faculty.getCampusId())
                            .setName(faculty.getName())
                            .setIcon(faculty.getIcon())
                            .setStudyPrograms(FacultyMapper.mapStudyPrograms(faculty))
                            .setInformation(FacultyMapper.mapFacultyInformation(faculty))
                ).collect(Collectors.toCollection(ArrayList::new));
    }

    public static HashSet<StudyProgramDTO> mapStudyPrograms(Faculty faculty)
    {

        return faculty.getStudyPrograms().stream().map((studyProgram) ->
                new StudyProgramDTO()
                        .setId(studyProgram.getId())
                        .setName(studyProgram.getName())
                        .setDegree(new StudyProgramDegreeDTO().setLevel(studyProgram.getDegree().getLevel()))
                        .setFacultyId(faculty.getId())
                        .setLocation(new StudyProgramLocationDTO().setName(studyProgram.getLocation().getName()))
        ).collect(Collectors.toCollection(HashSet::new));

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
