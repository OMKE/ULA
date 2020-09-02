package com.ula.faculty.mapper;

import com.ula.faculty.domain.model.StudyProgram;
import com.ula.faculty.domain.model.Subject;
import com.ula.faculty.domain.model.YearOfStudy;
import com.ula.faculty.dto.model.StudyProgramWithYearsOfStudyDTO;
import com.ula.faculty.dto.model.YearOfStudyWithSubjectsDTO;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// Maps StudyProgramWithYearsOfStudyDTO class
public class StudyProgramWithSubjectsMapper
{

    public static StudyProgramWithYearsOfStudyDTO map(StudyProgram studyProgram)
    {
        return new StudyProgramWithYearsOfStudyDTO()
                    .setYears(StudyProgramWithSubjectsMapper.map(studyProgram.getYearsOfStudy()));
    }

//    Maps YearOfStudyWithSubjects, there is another mapper for YearOfStudy but that doesn't return subjects of that year, becase sometimes we don't need all that data
//    So we created another DTO object which holds subjects
    public static YearOfStudyWithSubjectsDTO map(YearOfStudy yearOfStudy)
    {
        return new YearOfStudyWithSubjectsDTO()
                    .setId(yearOfStudy.getId())
                    .setStudyProgramId(yearOfStudy.getStudyProgram().getId())
                    .setOrdinalNumber(yearOfStudy.getOrdinalNumber())
                    .setYear(yearOfStudy.getYear())
                    .setSubjects(SubjectMapper
                            .map(yearOfStudy.getSubjects()
                                    .stream()
                                    .sorted(Comparator.comparingInt(Subject::getSemester)) // Sorting by semester number, so it goes from one through n
                                    .collect(Collectors.toList())));
    }

    /*
        Returns a collection of YearsOfStudy with Subjects DTO, sorted by Year's ordinal number which goes from 1 to n number of years, commonly 4
     */
    public static List<YearOfStudyWithSubjectsDTO> map(Set<YearOfStudy> yearOfStudies)
    {
        return yearOfStudies.stream()
                .sorted(Comparator.comparingLong(YearOfStudy::getOrdinalNumber))
                .map(StudyProgramWithSubjectsMapper::map)
                .collect(Collectors.toList());
    }
}
