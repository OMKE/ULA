package com.ula.authentication.mapper;

import com.ula.authentication.domain.model.Teacher;
import com.ula.authentication.dto.model.TeacherDTO;
import org.ula.core.domain.model.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TeacherMapper
{
    public static TeacherDTO map(Teacher teacher)
    {
        return new TeacherDTO()
                    .setId(teacher.getId())
                    .setBiography(teacher.getBiography())
                    .setDeleted(teacher.isDeleted())
                    .setCreatedAt(teacher.getCreatedAt())
                    .setUpdatedAt(teacher.getUpdatedAt())
                    .setUser
                            (
                            new UserDTO()
                                .setId(teacher.getUser().getId())
                                .setUsername(teacher.getUser().getUsername())
                                .setEmail(teacher.getUser().getEmail())
                                .setFirstName(teacher.getUser().getFirstName())
                                .setLastName(teacher.getUser().getLastName())
                                .setProfileImage(teacher.getUser().getProfileImage())
                        );
    }

    public static List<TeacherDTO> map(List<Teacher> teachers)
    {
        return teachers.stream().map(TeacherMapper::map).collect(Collectors.toList());
    }
}
