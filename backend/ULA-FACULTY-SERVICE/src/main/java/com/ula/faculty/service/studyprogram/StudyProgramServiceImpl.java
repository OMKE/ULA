package com.ula.faculty.service.studyprogram;

import com.ula.faculty.api.v1.request.StoreAndUpdateStudyProgramRequest;
import com.ula.faculty.domain.model.Faculty;
import com.ula.faculty.domain.model.StudyProgram;
import com.ula.faculty.domain.model.StudyProgramDegree;
import com.ula.faculty.domain.model.StudyProgramLocation;
import com.ula.faculty.domain.repository.FacultyRepository;
import com.ula.faculty.domain.repository.StudyProgramDegreeRepository;
import com.ula.faculty.domain.repository.StudyProgramLocationRepository;
import com.ula.faculty.domain.repository.StudyProgramRepository;
import com.ula.faculty.dto.model.StudyProgramDTO;
import com.ula.faculty.dto.model.StudyProgramWithNumberOfPagesDTO;
import com.ula.faculty.dto.model.StudyProgramWithYearsOfStudyDTO;
import com.ula.faculty.mapper.StudyProgramMapper;
import com.ula.faculty.mapper.StudyProgramWithSubjectsMapper;
import com.ula.faculty.service.exception.FacultyNotFoundException;
import com.ula.faculty.service.exception.StudyProgramDegreeNotFoundException;
import com.ula.faculty.service.exception.StudyProgramLocationNotFoundException;
import com.ula.faculty.service.exception.StudyProgramNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyProgramServiceImpl implements StudyProgramService
{

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private StudyProgramRepository studyProgramRepository;

    @Autowired
    private StudyProgramDegreeRepository studyProgramDegreeRepository;

    @Autowired
    private StudyProgramLocationRepository studyProgramLocationRepository;


    @Override
    public StudyProgramWithNumberOfPagesDTO index(Long facultyId, Pageable pageable) throws FacultyNotFoundException
    {
        Faculty faculty = facultyRepository.findById(facultyId).orElseThrow(
                () -> new FacultyNotFoundException(
                String.format("Faculty with id:%s does not exist", facultyId)));

        Page<StudyProgram> studyPrograms = studyProgramRepository.findAllByFacultyId(faculty.getId(), pageable);
        int totalPages = studyPrograms.getTotalPages();

        List<StudyProgramDTO> studyProgramDTOS = StudyProgramMapper.map(studyPrograms);

        return new StudyProgramWithNumberOfPagesDTO()
                    .setStudyPrograms(studyProgramDTOS)
                    .setTotalPages(totalPages-1);

    }



    @Override
    public StudyProgramDTO show(Long id) throws StudyProgramNotFoundException
    {
        return StudyProgramMapper.map(this.studyProgramRepository.findById(id)
                .orElseThrow(() -> new StudyProgramNotFoundException(String.format("Study program with id: %s not found", id))));
    }



    @Override
    public String store(StoreAndUpdateStudyProgramRequest request)
    throws StudyProgramLocationNotFoundException, StudyProgramDegreeNotFoundException, FacultyNotFoundException
    {

        Faculty faculty = this.facultyRepository.findById(request.getFacultyId())
                                                .orElseThrow(() ->
                                                 new FacultyNotFoundException
                                                         (String.format("Faculty with id: %s could not be found", request.getFacultyId())));

        StudyProgramLocation studyProgramLocation = this.studyProgramLocationRepository
                                        .findById(request.getLocationId())
                                        .orElseThrow(() ->
                                                             new StudyProgramLocationNotFoundException
                                                                     (
                                                                            String.format("Study program location with id: %s could not be found",
                                                                                           request.getLocationId())));
        StudyProgramDegree studyProgramDegree = this.studyProgramDegreeRepository
                                    .findById(request.getDegreeId())
                                    .orElseThrow(() ->
                                                 new StudyProgramDegreeNotFoundException
                                                         (String.format("Study program degree with id: %s could not be found", request.getDegreeId())));

        StudyProgram studyProgram = new StudyProgram()
                                .setName(request.getName())
                                .setDescription(request.getDescription())
                                .setFaculty(faculty)
                                .setLocation(studyProgramLocation)
                                .setDegree(studyProgramDegree);

        this.studyProgramRepository.save(studyProgram);

        return String.format("Study program: %s has been stored", studyProgram.getName());

    }

    @Override
    public String update(Long id, StoreAndUpdateStudyProgramRequest request)
    throws StudyProgramLocationNotFoundException, StudyProgramDegreeNotFoundException, FacultyNotFoundException, StudyProgramNotFoundException
    {

        StudyProgram studyProgram = this.studyProgramRepository.findById(id)
                                                               .orElseThrow(
                                                                       () ->
                                                                           new StudyProgramNotFoundException
                                                                                   (String.format("Study program with id: %s could not be found", id)));


        Faculty faculty = this.facultyRepository.findById(request.getFacultyId())
                                                .orElseThrow(() ->
                                                                     new FacultyNotFoundException
                                                                             (String.format("Faculty with id: %s could not be found", request.getFacultyId())));

        StudyProgramLocation studyProgramLocation = this.studyProgramLocationRepository
                .findById(request.getLocationId())
                .orElseThrow(() ->
                                     new StudyProgramLocationNotFoundException
                                             (
                                                     String.format("Study program location with id: %s could not be found",
                                                                   request.getLocationId())));
        StudyProgramDegree studyProgramDegree = this.studyProgramDegreeRepository
                .findById(request.getDegreeId())
                .orElseThrow(() ->
                                     new StudyProgramDegreeNotFoundException
                                             (String.format("Study program degree with id: %s could not be found", request.getDegreeId())));


        studyProgram.setName(request.getName())
                    .setDescription(request.getDescription())
                    .setFaculty(faculty)
                    .setLocation(studyProgramLocation)
                    .setDegree(studyProgramDegree);

        this.studyProgramRepository.save(studyProgram);

        return String.format("Study program: %s has been updated", studyProgram.getName());
    }

    @Override
    public String delete(Long id)
    throws StudyProgramNotFoundException
    {
        StudyProgram studyProgram = this.studyProgramRepository.findById(id)
                                                               .orElseThrow(
                                                                       () -> new StudyProgramNotFoundException
                                                                               (String.format("Study program with id: %s could not be found", id)));

        this.studyProgramRepository.deleteById(id);

        return String.format("Study program %s has been deleted", studyProgram.getName());
    }


    @Override
    public List<StudyProgramDTO> search(String searchTerm)
    {
        return StudyProgramMapper.map(studyProgramRepository.findStudyProgramByNameContains(searchTerm));
    }

    @Override
    public StudyProgramWithYearsOfStudyDTO subjects(Long id) throws StudyProgramNotFoundException
    {
        return StudyProgramWithSubjectsMapper.map(this.studyProgramRepository.findById(id)
                .orElseThrow(() -> new StudyProgramNotFoundException(String.format("Study program with id: %s not found", id))));
    }
}
