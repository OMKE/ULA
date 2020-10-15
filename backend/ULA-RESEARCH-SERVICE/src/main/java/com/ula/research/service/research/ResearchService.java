package com.ula.research.service.research;

import com.ula.research.dto.AuthorDTO;
import com.ula.research.dto.ResearchDTO;
import com.ula.research.service.exception.ResearchNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ResearchService
{
    List<ResearchDTO> index(Pageable pageable);

    ResearchDTO show(Long id)
    throws ResearchNotFoundException;

    String store(ResearchDTO researchDTO);

    List<AuthorDTO> getAuthors(Long researchId)
    throws ResearchNotFoundException;

    String storeThumbnailImage(Long researchId, MultipartFile file)
    throws ResearchNotFoundException;

    String storeThumbnailImage(MultipartFile file);

    String update(Long id, ResearchDTO researchDTO)
    throws ResearchNotFoundException;

    String delete(Long id)
    throws ResearchNotFoundException;
}
