package com.ula.authentication.service.teacher;

import com.ula.authentication.domain.model.Teacher;
import com.ula.authentication.domain.model.User;
import com.ula.authentication.domain.model.UserPermission;
import com.ula.authentication.domain.repository.PermissionRepository;
import com.ula.authentication.domain.repository.TeacherRepository;
import com.ula.authentication.domain.repository.UserPermissionRepository;
import com.ula.authentication.domain.repository.UserRepository;
import com.ula.authentication.dto.model.TeacherDTO;
import com.ula.authentication.mapper.TeacherMapper;
import com.ula.authentication.service.exception.TeacherNotFoundException;
import com.ula.authentication.service.exception.UserIsAlreadyTeacherException;
import com.ula.authentication.service.exception.UserNotFoundException;
import com.ula.authentication.service.exception.UserPermissionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService
{
    @Autowired
    private TeacherRepository teacherRepository;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Override
    public List<TeacherDTO> index()
    {
        return TeacherMapper.map(this.teacherRepository.findAllWithTrashed());
    }

    @Override
    public TeacherDTO getByUsername(String username)
    throws UserNotFoundException, TeacherNotFoundException
    {

        User user =this.userRepository
                .findByUsername(username)
                .orElseThrow(() ->
                                new UserNotFoundException(String.format("User with username: %s could not be found", username)));

        Teacher teacher = this.teacherRepository
                    .findByUserIdAndDeletedFalse(user.getId())
                    .orElseThrow(() -> new TeacherNotFoundException(String.format("Teacher with user id: %s could not be found", user.getId())));

        return TeacherMapper.map(teacher);

    }

    @Override
    public TeacherDTO show(Long id) throws TeacherNotFoundException
    {
        return TeacherMapper.map
                (
                    this.teacherRepository.findByIdTrashed(id)
                            .orElseThrow(() -> new TeacherNotFoundException(String.format("Teacher with id:%s could not be found", id)))

                );
    }

    @Override
    public String store(Long userId, TeacherDTO teacherDTO) throws UserNotFoundException, UserIsAlreadyTeacherException
    {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id: %s could not be found", userId)));

        if (
            user.getUserPermissions()
                .stream()
                .anyMatch
                        (
                                userPermission -> userPermission
                                        .getPermission().equals(permissionRepository.ROLE_TEACHER()) && !userPermission.isDeleted()
                        )
        )
        {
            throw new UserIsAlreadyTeacherException(String.format("User with id: %s is already a teacher", userId));
        }

        // Add permissions to user entity
        user.getUserPermissions().add(new UserPermission().setUser(user).setPermission(permissionRepository.ROLE_TEACHER()));

        // Save user
        userRepository.save(user);

        // Save admin
        teacherRepository.save
                (
                        new Teacher()
                                .setBiography(teacherDTO.getBiography())
                                .setUser(user)
                );
        return String.format("User: %s has been stored as teacher", user.getUsername());
    }

    @Override
    public String update(Long id, TeacherDTO teacherDTO) throws TeacherNotFoundException
    {
        Teacher teacher = this.teacherRepository.findById(id)
                        .orElseThrow
                                (
                                    () -> new TeacherNotFoundException(String.format("Teacher with id: %s could not be found", id))
                                );

        teacher.setBiography(teacherDTO.getBiography());

        this.teacherRepository.save(teacher);
        return "Teacher's biography has been updated";
    }

    @Override
    public String delete(Long id) throws TeacherNotFoundException, UserNotFoundException, UserPermissionException
    {
        Teacher teacher = this.teacherRepository.findById(id)
                .orElseThrow
                        (() ->
                                new TeacherNotFoundException(String.format("Teacher with id: %s could not be found", id))
                        );


        // Get user
        User user = userRepository.findById(teacher.getUser().getId()).orElseThrow(() -> new UserNotFoundException("User with id: %s could not be found"));

        String teacherRole = permissionRepository.ROLE_TEACHER().getTitle();

        // Filters through user's permissions and looks for TEACHER title, if it's found, get's first and soft deletes by it's id
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
                                                                .equals(teacherRole) && !userPermission.isDeleted()
                                        )
                                .findAny().orElseThrow(() -> new UserPermissionException("User permission could not be found")).getId()

                );

        this.teacherRepository.deleteById(teacher.getId());
        return String.format("Teacher: %s has been deleted", user.getUsername());

    }

    @Override
    public String restore(Long id) throws TeacherNotFoundException, UserNotFoundException, UserPermissionException
    {
        Teacher teacher = this.teacherRepository.findByIdTrashed(id)
                .orElseThrow
                        (() ->
                                new TeacherNotFoundException(String.format("Teacher with id: %s could not be found", id))
                        );


        // Get user
        User user = userRepository.findById(teacher.getUser().getId()).orElseThrow(() -> new UserNotFoundException("User with id: %s could not be found"));

        String teacherRole = permissionRepository.ROLE_TEACHER().getTitle();

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
                                                                .equals(teacherRole) && userPermission.isDeleted()
                                        )
                                .findAny().orElseThrow(() -> new UserPermissionException("User permission could not be found")).getId()

                );

        this.teacherRepository.restoreById(teacher.getId());
        return String.format("Teacher: %s has been restored", user.getUsername());
    }
}
