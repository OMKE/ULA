package com.ula.university.service.universityinformation;

import com.ula.university.domain.model.UniversityInformation;
import com.ula.university.domain.repository.UniversityInformationRepository;
import com.ula.university.dto.model.UniversityInformationDTO;
import com.ula.university.service.exception.UniversityInformationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UniversityInformationServiceImpl implements UniversityInformationService
{


    @Autowired
    private UniversityInformationRepository universityInformationRepository;

    @Override
    public UniversityInformationDTO index() throws UniversityInformationNotFoundException
    {
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(1L).orElseThrow(() -> new UniversityInformationNotFoundException(String.format("University information with university id: %s not found", 1L)));
        return new UniversityInformationDTO()
                .setAbout(universityInformation.getAbout())
                .setPublishing(universityInformation.getPublishing())
                .setTeachingStaff(universityInformation.getTeachingStaff())
                .setHistory(universityInformation.getHistory())
                .setPresident(universityInformation.getPresident());
    }

    @Override
    public String about() throws UniversityInformationNotFoundException
    {
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(1L).orElseThrow(() -> new UniversityInformationNotFoundException(String.format("University information with university id: %s not found", 1L)));
        return universityInformation.getAbout();
    }

    @Override
    public String updateAbout(String about) throws UniversityInformationNotFoundException
    {
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(1L).orElseThrow(() -> new UniversityInformationNotFoundException(String.format("University information with university id: %s not found", 1L)));

        universityInformation.setAbout(about);
        this.universityInformationRepository.save(universityInformation);
        return "University About has been updated.";

    }

    @Override
    public String history() throws UniversityInformationNotFoundException
    {
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(1L).orElseThrow(() -> new UniversityInformationNotFoundException(String.format("University information with university id: %s not found", 1L)));

        return universityInformation.getHistory();
    }

    @Override
    public String updateHistory(String history) throws UniversityInformationNotFoundException
    {
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(1L).orElseThrow(() -> new UniversityInformationNotFoundException(String.format("University information with university id: %s not found", 1L)));

        universityInformation.setHistory(history);
        this.universityInformationRepository.save(universityInformation);
        return "University History has been updated.";
    }

    @Override
    public String president() throws UniversityInformationNotFoundException
    {
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(1L).orElseThrow(() -> new UniversityInformationNotFoundException(String.format("University information with university id: %s not found", 1L)));

        return universityInformation.getPresident();
    }

    @Override
    public String updatePresident(String president) throws UniversityInformationNotFoundException
    {
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(1L).orElseThrow(() -> new UniversityInformationNotFoundException(String.format("University information with university id: %s not found", 1L)));

        universityInformation.setPresident(president);
        this.universityInformationRepository.save(universityInformation);
        return "University President has been updated.";
    }

    @Override
    public String teachingStaff() throws UniversityInformationNotFoundException
    {
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(1L).orElseThrow(() -> new UniversityInformationNotFoundException(String.format("University information with university id: %s not found", 1L)));

        return universityInformation.getTeachingStaff();
    }

    @Override
    public String updateTeachingStaff(String teachingStaff) throws UniversityInformationNotFoundException
    {
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(1L).orElseThrow(() -> new UniversityInformationNotFoundException(String.format("University information with university id: %s not found", 1L)));

        universityInformation.setTeachingStaff(teachingStaff);
        this.universityInformationRepository.save(universityInformation);
        return "University Teaching Staff has been updated.";
    }

    @Override
    public String publishing() throws UniversityInformationNotFoundException
    {
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(1L).orElseThrow(() -> new UniversityInformationNotFoundException(String.format("University information with university id: %s not found", 1L)));

        return universityInformation.getPublishing();
    }

    @Override
    public String updatePublishing(String publishing) throws UniversityInformationNotFoundException
    {
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(1L).orElseThrow(() -> new UniversityInformationNotFoundException(String.format("University information with university id: %s not found", 1L)));

        universityInformation.setPublishing(publishing);
        this.universityInformationRepository.save(universityInformation);
        return "University Publishing has been updated.";
    }
}
