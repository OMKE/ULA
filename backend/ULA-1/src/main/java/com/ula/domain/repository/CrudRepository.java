package com.ula.domain.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import com.ula.domain.model.BaseEntity;

/*
 * Extends JPA CrudRepository and overrides methods so we can use soft deletes
 */

@NoRepositoryBean
public interface CrudRepository<T extends BaseEntity, ID extends Serializable>
		extends org.springframework.data.repository.CrudRepository<T, ID> {
	
	
	/*
	 * @desc - Finds all entities which are not soft deleted
	 */

	@Override
	@Query("select e from #{#entityName} e where e.deleted=false")
	public List<T> findAll();

	/*
	 * @desc - Finds all, even if entity is soft deleted
	 */
	@Query("select e from #{#entityName} e")
	public List<T> findAllWithTrashed();

	/*
	 * @desc - Finds an entity with given Id if it's not soft deleted
	 */

	@Override
	@Query("select e from #{#entityName} e where e.deleted=false and e.id=?1")
	public Optional<T> findById(ID id);

	/*
	 * @desc - Finds an entity even if it's soft deleted
	 */
	@Query("select e from #{#entityName} e where e.id=?1")
	public Optional<T> findByIdTrashed(ID id);


	/*
	 * @desc - Finds all entities that are soft deleted
	 */

	@Query("select e from #{#entityName} e where e.deleted=true")
	public List<T> findAllTrashed();


	/*
	 * @desc - Soft deletes an entity with given id
	 */
	@Override
	@Query("update #{#entityName} e set e.deleted=true where e.id=?1")
	@Modifying
	public void deleteById(ID id);

	/*
	 * @desc - Restores an entity, setting deleted column to false
	 */

	@Query("update #{#entityName} e set e.deleted=false where e.id=?1")
	@Modifying
	@Transactional
	public void restoreById(ID id);

	/*
	 * @TODO - work with entity types
	 * 
	 * @Query("update #{#entityName} t set e.deleted=false where t.id=?1")
	 * 
	 * @Transactional
	 * 
	 * @Modifying public void softDelete(T entity);
	 */

	/*
	 * @desc - Permanently deletes an entity with given id
	 */
	@Query("delete #{#entityName} e where e.id=?1")
	@Modifying
	public void forceDelete(ID id);






}
