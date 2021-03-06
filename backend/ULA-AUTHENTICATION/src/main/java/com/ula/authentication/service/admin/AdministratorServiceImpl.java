package com.ula.authentication.service.admin;

import com.ula.authentication.domain.model.Administrator;
import com.ula.authentication.domain.model.User;
import com.ula.authentication.domain.model.UserPermission;
import com.ula.authentication.domain.repository.AdministratorRepository;
import com.ula.authentication.domain.repository.PermissionRepository;
import com.ula.authentication.domain.repository.UserPermissionRepository;
import com.ula.authentication.domain.repository.UserRepository;
import com.ula.authentication.dto.model.AdminDTO;
import com.ula.authentication.mapper.AdministratorMapper;
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
        return AdministratorMapper.map(administratorRepository.findAllWithTrashed());
    }

    @Override
    public AdminDTO show(Long id) throws AdministratorNotFoundException
    {
        return AdministratorMapper.map
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
                                                .getPermission().equals(permissionRepository.ROLE_ADMIN()) && !userPermission.isDeleted()
                                )
        )
        {
            throw new UserIsAlreadyAdministratorException(String.format("User with id: %s is already an administrator", userId));
        }

        // Add permissions to user entity
        user.getUserPermissions().add(new UserPermission().setUser(user).setPermission(permissionRepository.ROLE_ADMIN()));

        // Save user
        userRepository.save(user);

        // Save admin
        administratorRepository.save
                (
                    new Administrator().setUser(user)
                );
        return String.format("User: %s has been stored as administrator", user.getUsername());
    }

    @Override
    public String delete(Long id) throws UserNotFoundException, UserPermissionException, AdministratorNotFoundException
    {

        Administrator administrator = administratorRepository.findById(id)
                .orElseThrow
                        (() ->
                            new AdministratorNotFoundException(String.format("Administrator with id: %s could not be found", id))
                        );


        // Get user
        User user = userRepository.findById(administrator.getUser().getId()).orElseThrow(() -> new UserNotFoundException("User with id: %s could not be found"));

        String adminRole = permissionRepository.ROLE_ADMIN().getTitle();

        // Filters through user's permissions and looks for ADMIN title, if it's found, get's first and soft deletes by it's id
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
                                                        .equals(adminRole) && !userPermission.isDeleted()
                                        )
                                .findAny().orElseThrow(() -> new UserPermissionException("User permission could not be found")).getId()

                );

        administratorRepository.deleteById(administrator.getId());
        return String.format("Administrator: %s has been deleted", user.getUsername());
    }

    @Override
    public String restore(Long id) throws UserNotFoundException, UserPermissionException, AdministratorNotFoundException
    {
        Administrator administrator = administratorRepository.findByIdTrashed(id)
                .orElseThrow
                        (() ->
                                new AdministratorNotFoundException(String.format("Administrator with id: %s could not be found", id))
                        );


        // Get user
        User user = userRepository.findById(administrator.getUser().getId()).orElseThrow(() -> new UserNotFoundException("User with id: %s could not be found"));

        String adminRole = permissionRepository.ROLE_ADMIN().getTitle();

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
                                                                .equals(adminRole) && userPermission.isDeleted()
                                        )
                                .findAny().orElseThrow(() -> new UserPermissionException("User permission could not be found")).getId()
                );

        administratorRepository.restoreById(administrator.getId());
        return String.format("Administrator: %s has been restored", user.getUsername());
    }
}
