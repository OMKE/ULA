package com.ula.faculty.service.yearofstudy;

import com.ula.faculty.domain.model.StudyProgram;
import com.ula.faculty.domain.repository.StudyProgramRepository;
import com.ula.faculty.domain.repository.YearOfStudyRepository;
import com.ula.faculty.dto.model.YearOfStudyDTO;
import com.ula.faculty.mapper.YearOfStudyMapper;
import com.ula.faculty.service.exception.StudyProgramNotFoundException;
import com.ula.faculty.service.exception.YearOfStudyNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearOfStudyServiceImpl implements YearOfStudyService
{

    @Autowired
    private YearOfStudyRepository yearOfStudyRepository;

    @Autowired
    private StudyProgramRepository studyProgramRepository;



    @Override
    public List<YearOfStudyDTO> index(Long studyProgramId) throws StudyProgramNotFoundException
    {
        StudyProgram studyProgram = this.studyProgramRepository.findById(studyProgramId)
                .orElseThrow(() -> new StudyProgramNotFoundException(String.format("Study program with id: %s not found", studyProgramId)));

        return YearOfStudyMapper.map(this.yearOfStudyRepository.findAllByStudyProgramId(studyProgram.getId()));
    }

    @Override
    public YearOfStudyDTO show(Long id) throws YearOfStudyNotFoundException
    {
        return YearOfStudyMapper.map(this.yearOfStudyRepository.findById(id)
                .orElseThrow(() -> new YearOfStudyNotFoundException(String.format("Year of study with id: %s not found", id))));
    }
}
