package com.ula.university.service.university;


import com.ula.university.domain.model.University;
import com.ula.university.domain.model.UniversityInformation;
import com.ula.university.domain.repository.UniversityInformationRepository;
import com.ula.university.domain.repository.UniversityRepository;
import com.ula.university.dto.model.AddressDTO;
import com.ula.university.dto.model.UniversityDTO;
import com.ula.university.dto.model.UniversityInformationDTO;
import com.ula.university.feign.FacultyFeignClient;
import com.ula.university.mapper.FacultyMapper;
import com.ula.university.service.exception.UniversityInformationNotFoundException;
import com.ula.university.service.exception.UniversityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UniversityServiceImpl implements UniversityService 
{

    @Autowired
    private FacultyFeignClient facultyFeignClient;

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private UniversityInformationRepository universityInformationRepository;




    @Override
    public UniversityDTO index() throws UniversityNotFoundException, UniversityInformationNotFoundException
    {
        University university = this.universityRepository.findByName("University of Los Angeles").orElseThrow(() -> new UniversityNotFoundException("University of Los Angeles not found."));
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(university.getId()).orElseThrow(() -> new UniversityInformationNotFoundException("University Information not found."));

//        Getting faculty objects from 'ula-faculty-service'
        Object faculties = facultyFeignClient.getFaculties().getPayload();

//        Building universityDTO which we will return
        UniversityDTO universityDTO = new UniversityDTO()
                    .setName(university.getName())
                    .setFaculties(FacultyMapper.mapFaculties(faculties))
                    .setAddress(
                            new AddressDTO()
                                    .setNumber(university.getAddress().getNumber())
                                    .setCityName(university.getAddress().getCity().getName())
                                    .setPostalCode(university.getAddress().getPostalCode())
                                    .setStreetName(university.getAddress().getStreetName())
                    )
                    .setInformation(
                            new UniversityInformationDTO()
                                    .setAbout(universityInformation.getAbout())
                                    .setHistory(universityInformation.getHistory())
                                    .setPresident(universityInformation.getPresident())
                                    .setPublishing(universityInformation.getPublishing())
                                    .setTeachingStaff(universityInformation.getTeachingStaff())
                    )
                    .setEstablishmentDate(university.getEstablishmentDate())
                    .setPhoneNumbersToDTO(university);

        return universityDTO;
    }

    @Override
    public UniversityInformationDTO information() throws UniversityInformationNotFoundException
    {
        UniversityInformation universityInformation = this.universityInformationRepository.findByUniversityId(1L).orElseThrow(() -> new UniversityInformationNotFoundException(String.format("University information with university id: %s not found", 1L)));
        return new UniversityInformationDTO()
                .setAbout(universityInformation.getAbout())
                .setPublishing(universityInformation.getPublishing())
                .setTeachingStaff(universityInformation.getTeachingStaff())
                .setHistory(universityInformation.getHistory())
                .setPresident(universityInformation.getPresident());
    }

}
