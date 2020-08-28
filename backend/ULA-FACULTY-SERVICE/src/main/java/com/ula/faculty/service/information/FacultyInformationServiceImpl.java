package com.ula.faculty.service.information;

import com.ula.faculty.domain.repository.FacultyInformationRepository;
import com.ula.faculty.dto.model.FacultyInformationDTO;
import com.ula.faculty.mapper.FacultyInformationMapper;
import com.ula.faculty.service.exception.FacultyInformationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FacultyInformationServiceImpl implements FacultyInformationService
{

    @Autowired
    private FacultyInformationRepository facultyInformationRepository;

    @Override
    public List<FacultyInformationDTO> index()
    {
        return FacultyInformationMapper.map(this.facultyInformationRepository.findAll());
    }

    @Override
    public FacultyInformationDTO show(Long id)
    throws FacultyInformationException
    {
        return FacultyInformationMapper.map
                (
                        this.facultyInformationRepository.findById(id)
                            .orElseThrow(() -> new FacultyInformationException(String.format("Faculty information with id: %s could not be found", id)))
                );
    }

    @Override
    public String store(FacultyInformationDTO facultyInformationDTO)
    {
        return null;
    }

    @Override
    public String update(Long id, FacultyInformationDTO facultyInformationDTO)
    {
        return null;
    }

    @Override
    public String delete(Long id)
    {
        return null;
    }
}
