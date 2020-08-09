package com.ula.authentication.service.user;

import com.ula.authentication.domain.model.UserPermission;
import com.ula.authentication.service.exception.UserPermissionException;

import java.util.Set;



public interface UserPermissionService {
	
	
	Set<UserPermission> getPermissionsById(Long id) throws UserPermissionException;

}
