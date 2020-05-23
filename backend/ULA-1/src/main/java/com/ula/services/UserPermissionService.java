package com.ula.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ula.models.UserPermission;
import com.ula.repositories.UserPermissionRepository;

@Service
public class UserPermissionService {

	@Autowired
	private UserPermissionRepository userPermissionRepository;

	public Set<UserPermission> getPermissionsById(Long id) {
		return userPermissionRepository.getByUserId(id);
	}

}
