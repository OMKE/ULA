package com.ula.university.service.universityinformation;

import com.ula.university.dto.model.UniversityInformationDTO;
import com.ula.university.service.exception.UniversityInformationNotFoundException;

public interface UniversityInformationService
{
    UniversityInformationDTO index() throws UniversityInformationNotFoundException;

    String about() throws UniversityInformationNotFoundException;
    String updateAbout(String about) throws UniversityInformationNotFoundException;

    String history() throws UniversityInformationNotFoundException;
    String updateHistory(String history) throws UniversityInformationNotFoundException;

    String president() throws UniversityInformationNotFoundException;
    String updatePresident(String president) throws UniversityInformationNotFoundException;

    String teachingStaff() throws UniversityInformationNotFoundException;
    String updateTeachingStaff(String teachingStaff) throws UniversityInformationNotFoundException;

    String publishing() throws UniversityInformationNotFoundException;
    String updatePublishing(String publishing) throws UniversityInformationNotFoundException;
}
