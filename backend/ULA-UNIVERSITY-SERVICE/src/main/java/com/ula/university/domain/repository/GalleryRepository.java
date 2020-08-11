package com.ula.university.domain.repository;

import com.ula.university.domain.model.Gallery;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends CrudRepository<Gallery, Long>
{
}
