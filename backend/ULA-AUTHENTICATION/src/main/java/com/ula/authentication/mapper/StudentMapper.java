package com.ula.authentication.mapper;

import com.ula.authentication.domain.model.Student;
import com.ula.authentication.dto.model.StudentDTO;
import org.ula.core.domain.model.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper
{
    public static StudentDTO map(Student student)
    {
        return new StudentDTO()
                    .setId(student.getId())
                    .setDateOfBirth(student.getDateOfBirth())
                    .setPhoneNumber(student.getPhoneNumber())
                    .setSsn(student.getSsn())
                    .setDeleted(student.isDeleted())
                    .setCreatedAt(student.getCreatedAt())
                    .setUpdatedAt(student.getUpdatedAt())
                    .setUser
                            (
                                new UserDTO()
                                    .setId(student.getUser().getId())
                                    .setUsername(student.getUser().getUsername())
                                    .setFirstName(student.getUser().getFirstName())
                                    .setLastName(student.getUser().getLastName())
                                    .setEmail(student.getUser().getEmail())
                                    .setProfileImage(student.getUser().getProfileImage())
                            );
    }

    public static List<StudentDTO> map(List<Student> students)
    {
        return students.stream().map(StudentMapper::map).collect(Collectors.toList());
    }
}
