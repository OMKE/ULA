package com.ula.research.service.author;

import com.ula.research.domain.model.Author;
import com.ula.research.domain.model.Research;
import com.ula.research.domain.repository.AuthorRepository;
import com.ula.research.domain.repository.ResearchRepository;
import com.ula.research.dto.AuthorDTO;
import com.ula.research.service.exception.AuthorNotFoundException;
import com.ula.research.service.exception.ResearchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService
{
    @Autowired
    private ResearchRepository researchRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public String store(Long researchId, AuthorDTO authorDTO)
    throws ResearchNotFoundException
    {
        Research research = this.researchRepository
                .findById(researchId)
                .orElseThrow(() -> new ResearchNotFoundException(String.format("Research with id: %s could not be found", researchId)));

        research
                .getAuthors()
                .add
                        (
                                new Author()
                                        .setResearch(research)
                                        .setFirstName(authorDTO.getFirstName())
                                        .setLastName(authorDTO.getLastName())
                        );

        this.researchRepository.save(research);
        return "Author has been added";
    }

    @Override
    public String update(Long researchId, Long authorId, AuthorDTO authorDTO)
    throws ResearchNotFoundException, AuthorNotFoundException
    {
        Research research = this.researchRepository
                .findById(researchId)
                .orElseThrow(() -> new ResearchNotFoundException(String.format("Research with id: %s could not be found", researchId)));

        Author author = this.authorRepository
                .findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(String.format("Author with id: %s could not be found", authorId)));

        author
                .setFirstName(authorDTO.getFirstName())
                .setLastName(authorDTO.getLastName());

        this.authorRepository.save(author);

        return "Author has been updated";
    }

    @Override
    public String delete(Long researchId, Long authorId)
    throws ResearchNotFoundException, AuthorNotFoundException
    {
        Research research = this.researchRepository
                .findById(researchId)
                .orElseThrow(() -> new ResearchNotFoundException(String.format("Research with id: %s could not be found", researchId)));

        Author author = this.authorRepository
                .findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(String.format("Author with id: %s could not be found", authorId)));

        this.authorRepository.deleteById(authorId);

        return "Author has been deleted";
    }
}
