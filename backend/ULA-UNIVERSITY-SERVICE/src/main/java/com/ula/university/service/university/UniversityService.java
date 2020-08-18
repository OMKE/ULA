package com.ula.university.service.university;

import com.ula.university.dto.model.UniversityDTO;
import com.ula.university.dto.model.UniversityInformationDTO;
import com.ula.university.service.exception.UniversityInformationNotFoundException;
import com.ula.university.service.exception.UniversityNotFoundException;

public interface UniversityService
{
    UniversityDTO index() throws UniversityNotFoundException, UniversityInformationNotFoundException;

    UniversityInformationDTO information() throws UniversityInformationNotFoundException;
}
