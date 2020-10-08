package com.ula.authentication.domain.repository;

import com.ula.authentication.domain.model.ContentCreator;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentCreatorRepository extends CrudRepository<ContentCreator, Long>
{

    List<ContentCreator> findAllByDeletedFalse(Pageable pageable);

    Optional<ContentCreator> findByUserId(Long userId);
}
