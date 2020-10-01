package com.ula.research.mapper;

import com.ula.research.domain.model.Research;
import com.ula.research.dto.ResearchDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ResearchMapper
{
    public static ResearchDTO map(Research research)
    {
        return new ResearchDTO()
                    .setId(research.getId())
                    .setTitle(research.getTitle())
                    .setContent(research.getContent())
                    .setThumbnail(research.getThumbnail())
                    .setPublicationDate(research.getPublicationDate())
                    .setAuthors(AuthorMapper.map(research.getAuthors()));
    }

    public static List<ResearchDTO> map(List<Research> research)
    {
        return research.stream().map(ResearchMapper::map).collect(Collectors.toList());
    }
}
