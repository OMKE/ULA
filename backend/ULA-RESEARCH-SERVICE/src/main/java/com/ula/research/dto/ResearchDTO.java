package com.ula.research.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ResearchDTO
{
    private Long id;
    private String title;
    private String content;
    private String thumbnail;
    private Date publicationDate;
    private List<AuthorDTO> authors;

}
