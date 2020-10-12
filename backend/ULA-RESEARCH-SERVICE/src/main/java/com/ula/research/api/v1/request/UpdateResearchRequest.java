package com.ula.research.api.v1.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateResearchRequest
{
    @Size(min = 10, message = "Title has to be at least 10 characters long")
    @Size(max = 128, message = "Title can not be longer than 128 charcaters")
    @NotEmpty(message = "Title is required")
    private String title;

    @Size(min = 128, message = "Content has to be at least 128 characters long")
    @NotEmpty(message = "Content is required")
    private String content;


    @NotNull(message = "Publication date is required")
    private Date publicationDate;

    // Optional
    private String thumbnailImage;

}
