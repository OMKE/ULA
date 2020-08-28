package com.ula.authentication.service.admin;

import com.ula.authentication.dto.model.AdminDTO;
import com.ula.authentication.service.exception.AdministratorNotFoundException;
import com.ula.authentication.service.exception.UserIsAlreadyAdministratorException;
import com.ula.authentication.service.exception.UserNotFoundException;
import com.ula.authentication.service.exception.UserPermissionException;

import java.util.List;

public interface AdministratorService
{

    List<AdminDTO> index();
    AdminDTO show(Long id) throws AdministratorNotFoundException;
    String store(Long userId) throws UserNotFoundException, UserIsAlreadyAdministratorException;
    String delete(Long id) throws UserNotFoundException, UserPermissionException, AdministratorNotFoundException;
    String restore(Long id) throws UserNotFoundException, UserPermissionException, AdministratorNotFoundException;
}
