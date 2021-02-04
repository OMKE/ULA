package com.ula.research.service.author;

import com.ula.research.dto.AuthorDTO;
import com.ula.research.service.exception.AuthorNotFoundException;
import com.ula.research.service.exception.ResearchNotFoundException;

public interface AuthorService
{
    String store(Long researchId, AuthorDTO authorDTO)
    throws ResearchNotFoundException;

    String update(Long researchId, Long authorId, AuthorDTO authorDTO)
    throws ResearchNotFoundException, AuthorNotFoundException;

    String delete(Long researchId, Long authorId)
    throws ResearchNotFoundException, AuthorNotFoundException;
}
