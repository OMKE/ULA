package com.ula.authentication.service.teacher;

import com.ula.authentication.dto.model.TeacherDTO;
import com.ula.authentication.service.exception.TeacherNotFoundException;
import com.ula.authentication.service.exception.UserIsAlreadyTeacherException;
import com.ula.authentication.service.exception.UserNotFoundException;
import com.ula.authentication.service.exception.UserPermissionException;

import java.util.List;

public interface TeacherService
{
    List<TeacherDTO> index();

    TeacherDTO show(Long id) throws TeacherNotFoundException;

    String store(Long userId, TeacherDTO teacherDTO) throws UserNotFoundException, UserIsAlreadyTeacherException;

    String update(Long id, TeacherDTO teacherDTO) throws TeacherNotFoundException;

    String delete(Long id) throws TeacherNotFoundException, UserNotFoundException, UserPermissionException;
    String restore(Long id) throws TeacherNotFoundException, UserNotFoundException, UserPermissionException;
}
