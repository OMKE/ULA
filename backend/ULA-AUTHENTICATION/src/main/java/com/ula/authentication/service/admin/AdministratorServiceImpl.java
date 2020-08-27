package com.ula.authentication.service.admin;

import com.ula.authentication.domain.model.Administrator;
import com.ula.authentication.domain.model.User;
import com.ula.authentication.domain.model.UserPermission;
import com.ula.authentication.domain.repository.AdministratorRepository;
import com.ula.authentication.domain.repository.PermissionRepository;
import com.ula.authentication.domain.repository.UserPermissionRepository;
import com.ula.authentication.domain.repository.UserRepository;
import com.ula.authentication.dto.model.AdminDTO;
import com.ula.authentication.mapper.AdminMapper;
import com.ula.authentication.service.exception.AdministratorNotFoundException;
import com.ula.authentication.service.exception.UserIsAlreadyAdministratorException;
import com.ula.authentication.service.exception.UserNotFoundException;
import com.ula.authentication.service.exception.UserPermissionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService
{

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPermissionRepository userPermissionRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<AdminDTO> index()
    {
        return AdminMapper.map(administratorRepository.findAll());
    }

    @Override
    public AdminDTO show(Long id) throws AdministratorNotFoundException
    {
        return AdminMapper.map
                (
                    administratorRepository.findById(id)
                            .orElseThrow(() -> new AdministratorNotFoundException(String.format("Administrator with id: %s could not be found", id)))
                );
    }

    @Override
    public String store(Long userId) throws UserNotFoundException, UserIsAlreadyAdministratorException
    {
        // Get user
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id: %s could not be found"));
        if (
                user.getUserPermissions()
                        .stream()
                        .anyMatch
                                (
                                        userPermission -> userPermission
                                                .getPermission().equals(permissionRepository.ROLE_ADMIN())
                                )
        )
        {
            throw new UserIsAlreadyAdministratorException(String.format("User with id: %s is already an administrator", userId));
        }

        // Add permissions to user entity
        user.setProfileImage("users/admin-icon.png");
        user.getUserPermissions().add(new UserPermission().setUser(user).setPermission(permissionRepository.ROLE_ADMIN()));

        // Save user
        userRepository.save(user);

        // Save admin
        administratorRepository.save
                (
                    new Administrator().setUser(user)
                );
        return "Admin has been stored";
    }

    @Override
    public String delete(Long userId) throws UserNotFoundException, UserPermissionException, AdministratorNotFoundException
    {
        // Get user
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id: %s could not be found"));

        // Filters through user's permissions and looks for ROLE_ADMIN, if it's found, get's first and soft deletes by it's id
        userPermissionRepository.deleteById
                (
                        user.getUserPermissions()
                                .stream()
                                .filter
                                        (
                                            userPermission ->
                                                userPermission
                                                        .getPermission()
                                                        .equals(permissionRepository.ROLE_ADMIN())
                                        )
                                .findFirst().orElseThrow(() -> new UserPermissionException("User permission could not be found")).getId()

                );
        Administrator administrator = administratorRepository.findByUserId(userId)
                                                .orElseThrow
                                                        (() ->
                                                        new AdministratorNotFoundException(String.format("Admin with user id: %s could not be found", userId))
                                                        );
        administratorRepository.deleteById(administrator.getId());
        user.setProfileImage("users/user-icon.png");
        userRepository.save(user);
        return "Admin has been deleted";
    }
}
