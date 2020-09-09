package com.ula.student.feign.hystrix;

import com.ula.student.dto.StudentOnYearDTO;
import com.ula.student.dto.SubjectAttendanceWithSubjectDTO;
import com.ula.student.feign.FacultyService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacultyServiceFallbackFactory implements FallbackFactory<FacultyService>
{

    private static Logger LOGGER = LoggerFactory.getLogger(FacultyServiceFallbackFactory.class);

    @Override
    public FacultyService create(Throwable cause)
    {
        return new FacultyService()
        {
            @Override
            public StudentOnYearDTO getStudentOnYearByStudentId(String token, Long studentId)
            {
                LOGGER.error("Error occurred while fetching StudentOnYear", cause);
                return null;
            }

            @Override
            public List<SubjectAttendanceWithSubjectDTO> getAllSubjectAttendancesWithSubjects(
                    String token, Long studentOnYearId
                                                                                             )
            {
                LOGGER.error("Error occurred while fetching subject attendances with subjects", cause);
                return null;
            }

            @Override
            public List<SubjectAttendanceWithSubjectDTO> getPassedSubjectAttendancesWithSubjects(
                    String token, Long studentOnYearId
                                                                                                )
            {
                LOGGER.error("Error occurred while fetching passed subject attendances with subjects", cause);
                return null;
            }

            @Override
            public List<SubjectAttendanceWithSubjectDTO> getNotPassedSubjectAttendancesWithSubjects(
                    String token, Long studentOnYearId
                                                                                                   )
            {
                LOGGER.error("Error occurred while fetching not passed subject attendances with subjects", cause);
                return null;
            }

            @Override
            public SubjectAttendanceWithSubjectDTO getSubjectAttendanceById(
                    String token, Long studentId, Long id
                                                                           )
            {
                LOGGER.error(String.format("Error occurred while fetching subject attendance with id", id), cause);
                return null;
            }
        };
    }
}
