package com.ula.authentication.service.student;

import com.ula.authentication.dto.model.StudentDTO;
import com.ula.authentication.service.exception.*;

import java.util.List;

public interface StudentService
{
    List<StudentDTO> index();

    List<StudentDTO> getByIds(List<Long> studentIds);

    List<StudentDTO> search(String searchParam);

    StudentDTO show(Long id) throws StudentNotFoundException;

    String store(Long userId, StudentDTO studentDTO)
    throws UserNotFoundException, UserIsAlreadyStudent, StudentSSNConflictException;

    String update(Long id, StudentDTO studentDTO)
    throws StudentNotFoundException;

    String delete(Long id)
    throws StudentNotFoundException, UserNotFoundException, UserPermissionException;

    String restore(Long id)
    throws StudentNotFoundException, UserNotFoundException, UserPermissionException;

    StudentDTO getStudentBasedOnUsername(String username)
    throws UserNotFoundException, StudentNotFoundException;
}
