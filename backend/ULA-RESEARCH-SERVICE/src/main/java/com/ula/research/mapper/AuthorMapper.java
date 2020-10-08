package com.ula.research.mapper;

import com.ula.research.domain.model.Author;
import com.ula.research.dto.AuthorDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper
{
    public static AuthorDTO map(Author author)
    {
        return new AuthorDTO()
                    .setId(author.getId())
                    .setFirstName(author.getFirstName())
                    .setLastName(author.getLastName());
    }

    public static List<AuthorDTO> map(List<Author> authors)
    {
        return authors.stream().map(AuthorMapper::map).collect(Collectors.toList());
    }
}
