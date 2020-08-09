package com.ula.authentication.service.user;

import com.ula.authentication.domain.model.UserPermission;
import com.ula.authentication.domain.repository.UserPermissionRepository;
import com.ula.authentication.service.exception.UserPermissionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;



@Service
public class UserPermissionServiceImpl implements UserPermissionService {

	@Autowired
	private UserPermissionRepository userPermissionRepository;

	public Set<UserPermission> getPermissionsById(Long id) throws UserPermissionException
	{

		Set<UserPermission> userPermissions = userPermissionRepository.getByUserId(id);
		if (userPermissions.isEmpty()) {
			throw new UserPermissionException(
					String.format("Permissions for user id - '%s' do not exist", id));
		}

		return userPermissions;
	}

}
