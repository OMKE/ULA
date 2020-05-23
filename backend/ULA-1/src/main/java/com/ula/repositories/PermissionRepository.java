package com.ula.repositories;

import org.springframework.stereotype.Repository;

import com.ula.models.Permission;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long> {

}
