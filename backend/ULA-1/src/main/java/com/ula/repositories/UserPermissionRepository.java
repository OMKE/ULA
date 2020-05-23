package com.ula.repositories;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.ula.models.UserPermission;

@Repository
public interface UserPermissionRepository extends CrudRepository<UserPermission, Long> {
	Set<UserPermission> getByUserId(Long id);
}
