package com.ula.authentication.domain.repository;

import com.ula.authentication.domain.model.UserPermission;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.Set;



@Repository
public interface UserPermissionRepository extends CrudRepository<UserPermission, Long>
{
	Set<UserPermission> getByUserId(Long id);
}
