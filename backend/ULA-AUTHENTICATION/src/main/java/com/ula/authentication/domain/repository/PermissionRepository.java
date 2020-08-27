package com.ula.authentication.domain.repository;

import com.ula.authentication.domain.model.Permission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;


@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long>
{

	@Query("select e from #{#entityName} e where e.title='USER'")
	public Permission ROLE_USER();

	@Query("select e from #{#entityName} e where e.title='STAFF'")
	public Permission ROLE_STAFF();

	@Query("select e from #{#entityName} e where e.title='CONTENT_CREATOR'")
	public Permission ROLE_CONTENT_CREATOR();

	@Query("select e from #{#entityName} e where e.title='TEACHER'")
	public Permission ROLE_TEACHER();

	@Query("select e from #{#entityName} e where e.title='STUDENT'")
	public Permission ROLE_STUDENT();
}
