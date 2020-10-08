package com.ula.research.domain.repository;

import com.ula.research.domain.model.Author;
import org.springframework.stereotype.Repository;
import org.ula.core.domain.repository.CrudRepository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>
{

}
