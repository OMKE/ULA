package com.ula.authentication.service.student;

import com.ula.authentication.domain.model.Student;
import com.ula.authentication.domain.model.User;
import com.ula.authentication.domain.model.UserPermission;
import com.ula.authentication.domain.repository.PermissionRepository;
import com.ula.authentication.domain.repository.StudentRepository;
import com.ula.authentication.domain.repository.UserPermissionRepository;
import com.ula.authentication.domain.repository.UserRepository;
import com.ula.authentication.dto.model.StudentDTO;
import com.ula.authentication.mapper.StudentMapper;
import com.ula.authentication.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService
{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserPermissionRepository userPermissionRepository;


    @Override
    public List<StudentDTO> index()
    {
        return StudentMapper.map(studentRepository.findAllWithTrashed());
    }

    @Override
    public StudentDTO show(Long id) throws StudentNotFoundException
    {
        return StudentMapper.map
                (
                        studentRepository.findByIdWithTrashed(id)
                                .orElseThrow
                                        (
                                            () -> new StudentNotFoundException(String.format("Student with id: %s could not be found", id))
                                        )
                );
    }

    @Override
    public String store(Long userId, StudentDTO studentDTO)
    throws UserNotFoundException, UserIsAlreadyStudent, StudentSSNConflictException
    {
        // Find user with provided userId
        User user = this.userRepository.findById(userId)
                                       .orElseThrow(
                                               () -> new UserNotFoundException(
                                                       String.format("User with id: %s could not be found", userId))
                                                   );


        // check user permissions, if user already have role STUDENT, throw an exception
        if (
                user.getUserPermissions()
                    .stream()
                    .anyMatch
                            (
                                    userPermission -> userPermission
                                            .getPermission().equals(this.permissionRepository.ROLE_TEACHER()) && !userPermission.isDeleted()
                            )
        )
        {
            throw new UserIsAlreadyStudent(String.format("User with id: %s is already a student", userId));
        }
        Optional<Student> foundStudent = this.studentRepository.findBySsn(studentDTO.getSsn());
        if(foundStudent.isPresent()) {
            throw new StudentSSNConflictException(String.format("Student with ssn: %s already exists", studentDTO.getSsn()));
        }
        // Add STUDENT role to UserPermission
        user.getUserPermissions().add
                (
                        new UserPermission()
                                .setPermission(this.permissionRepository.ROLE_STUDENT())
                                .setUser(user)

                );

        // Update user with newly added role
        this.userRepository.save(user);

        // Create new student from StudentDTO
        Student student = new Student()
                .setPhoneNumber(studentDTO.getPhoneNumber())
                .setDateOfBirth(studentDTO.getDateOfBirth())
                .setSsn(studentDTO.getSsn())
                .setUser(user);

        // Save student
        this.studentRepository.save(student);
        return String.format("User: %s has been stored as student", user.getUsername());

    }

    @Override
    public String update(Long id, StudentDTO studentDTO)
    throws StudentNotFoundException
    {
        Student student = this.studentRepository.findById(id)
                                                .orElseThrow
                                                        (
                                                            () ->
                                                                new StudentNotFoundException(String.format("Student with id: %s could not be found", id))
                                                        );

        student.setDateOfBirth(studentDTO.getDateOfBirth())
               .setPhoneNumber(studentDTO.getPhoneNumber())
               .setSsn(studentDTO.getSsn());

        studentRepository.save(student);

        return "Student has been updated";
    }

    @Override
    public String delete(Long id)
    throws StudentNotFoundException, UserNotFoundException, UserPermissionException
    {
        Student student = this.studentRepository.findById(id)
                                                .orElseThrow
                                                        (() ->
                                                                 new StudentNotFoundException(String.format("Student with id: %s could not be found", id))
                                                        );


        // Get user
        User user = userRepository.findById(student.getUser().getId()).orElseThrow(() -> new UserNotFoundException("User with id: %s could not be found"));

        String studentRole = permissionRepository.ROLE_STUDENT().getTitle();

        // Filters through user's permissions and looks for STUDENT title, if it's found, get's first and soft deletes by it's id
        userPermissionRepository.deleteById
                (
                        user.getUserPermissions()
                            .stream()
                            .filter
                                    (
                                            userPermission ->
                                                    userPermission
                                                            .getPermission()
                                                            .getTitle()
                                                            .equals(studentRole) && !userPermission.isDeleted()
                                    )
                            .findAny().orElseThrow(() -> new UserPermissionException("User permission could not be found")).getId()

                );

        this.studentRepository.deleteById(student.getId());
        return String.format("Student: %s has been deleted", user.getUsername());
    }

    @Override
    public String restore(Long id)
    throws StudentNotFoundException, UserNotFoundException, UserPermissionException
    {
        Student student = this.studentRepository.findByIdTrashed(id)
                                                .orElseThrow
                                                        (() ->
                                                                 new StudentNotFoundException(String.format("Student with id: %s could not be found", id))
                                                        );


        // Get user
        User user = userRepository.findById(student.getUser().getId()).orElseThrow(() -> new UserNotFoundException("User with id: %s could not be found"));

        String studentRole = permissionRepository.ROLE_STUDENT().getTitle();

        // Filters through user's permissions and looks for ROLE_ADMIN, if it's found, get's first and soft deletes by it's id
        userPermissionRepository.restoreById
                (
                        user.getUserPermissions()
                            .stream()
                            .filter
                                    (
                                            userPermission ->
                                                    userPermission
                                                            .getPermission()
                                                            .getTitle()
                                                            .equals(studentRole) && userPermission.isDeleted()
                                    )
                            .findAny().orElseThrow(() -> new UserPermissionException("User permission could not be found")).getId()

                );

        this.studentRepository.restoreById(student.getId());
        return String.format("Student: %s has been restored", user.getUsername());
    }

    @Override
    public StudentDTO getStudentBasedOnUsername(String username)
    throws UserNotFoundException, StudentNotFoundException
    {
        User user = userRepository
                .findByUsernameAndDeletedFalse(username)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with username: %s could not be found", username)));

        Student student = this.studentRepository
                .getByUserId(user.getId())
                .orElseThrow(() -> new StudentNotFoundException(String.format("Student with user id: %s could not be found", user.getId())));

        return StudentMapper.map(student);

    }
}
