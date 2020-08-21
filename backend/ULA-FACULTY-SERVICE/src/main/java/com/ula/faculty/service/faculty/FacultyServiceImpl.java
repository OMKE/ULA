package com.ula.faculty.service.faculty;

import com.ula.faculty.domain.model.Faculty;
import com.ula.faculty.domain.repository.FacultyRepository;
import com.ula.faculty.domain.repository.StudyProgramRepository;
import com.ula.faculty.dto.model.FacultyDTO;
import com.ula.faculty.mapper.FacultyMapper;
import com.ula.faculty.service.exception.FacultyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService
{

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudyProgramRepository studyProgramRepository;

    @Override
    public List<FacultyDTO> index()
    {
        List<Faculty> faculties = facultyRepository.findAll();

        return FacultyMapper.mapFacultiesWithoutStudyProgramsAndInformation(faculties);
    }

    @Override
    public List<FacultyDTO> indexWithStudyPrograms()
    {
        List<Faculty> faculties = facultyRepository.findAll();

        return FacultyMapper.mapFacultiesWithStudyPrograms(faculties);
    }

    @Override
    public FacultyDTO show(Long id) throws FacultyNotFoundException
    {
        Faculty faculty = facultyRepository.findById(id).orElseThrow(() -> new FacultyNotFoundException(String.format("Faculty with provided id: %s not found", id)));
        return FacultyMapper.mapWithInformation(faculty);
    }
}
