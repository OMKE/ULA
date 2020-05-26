package com.ula.domain.repository;

import java.util.Set;

import org.springframework.stereotype.Repository;

import com.ula.domain.model.UserPermission;

@Repository
public interface UserPermissionRepository extends CrudRepository<UserPermission, Long> {
	Set<UserPermission> getByUserId(Long id);
}
