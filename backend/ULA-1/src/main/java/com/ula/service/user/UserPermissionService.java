package com.ula.service.user;

import java.util.Set;

import com.ula.domain.model.UserPermission;
import com.ula.service.exception.UserPermissionException;

public interface UserPermissionService {
	
	
	Set<UserPermission> getPermissionsById(Long id) throws UserPermissionException;

}
