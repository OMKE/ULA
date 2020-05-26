package com.ula.service.user;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ula.domain.model.UserPermission;
import com.ula.domain.repository.UserPermissionRepository;
import com.ula.service.exception.UserPermissionException;

@Service
public class UserPermissionServiceImpl implements UserPermissionService {

	@Autowired
	private UserPermissionRepository userPermissionRepository;

	public Set<UserPermission> getPermissionsById(Long id) throws UserPermissionException {

		Set<UserPermission> userPermissions = userPermissionRepository.getByUserId(id);
		if (userPermissions.isEmpty()) {
			throw new UserPermissionException(
					String.format("Permissions for user id - '%s' do not exist", id));
		}

		return userPermissions;
	}

}
