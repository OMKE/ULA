package com.ula.research.service.research;

import com.ula.research.domain.model.Author;
import com.ula.research.domain.model.Image;
import com.ula.research.domain.model.Research;
import com.ula.research.domain.repository.AuthorRepository;
import com.ula.research.domain.repository.ResearchRepository;
import com.ula.research.dto.ResearchDTO;
import com.ula.research.feign.StaticContentServiceFeignClient;
import com.ula.research.mapper.ResearchMapper;
import com.ula.research.service.exception.ResearchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.ula.core.util.JWTUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResearchServiceImpl implements ResearchService
{

    @Autowired
    private ResearchRepository researchRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private StaticContentServiceFeignClient staticContentService;

    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public List<ResearchDTO> index(Pageable pageable)
    {
        return ResearchMapper.map(this.researchRepository.findAllByDeletedFalseOrderByPublicationDateDesc(pageable));
    }

    @Override
    public ResearchDTO show(Long id)
    throws ResearchNotFoundException
    {
        return ResearchMapper.map
            (
                this.researchRepository.findById(id)
                .orElseThrow(() -> new ResearchNotFoundException(String.format("Research with id: %s could not be found", id)))
            );
    }

    @Override
    public String storeThumbnailImage(Long researchId, MultipartFile file)
    throws ResearchNotFoundException
    {
        Research research = this.researchRepository
                .findById(researchId)
                .orElseThrow(() -> new ResearchNotFoundException(String.format("Research work with id: %s could not be found", researchId)));

        String fileName = "research/" + this.staticContentService.addThumbnailImage(this.jwtUtil.getToken(), file).replace("\"", "");

        research.setThumbnail(fileName);

        this.researchRepository.save(research);

        return "Research image has been stored";
    }

    @Override
    public String storeThumbnailImage(MultipartFile file)
    {

        return this.staticContentService.addThumbnailImage(this.jwtUtil.getToken(), file).replace("\"", "");
    }

    @Override
    public String store(ResearchDTO researchDTO)
    {

        // Create new Research after image is stored

        Research research = new Research();

        research
                .setTitle(researchDTO.getTitle())
                .setContent(researchDTO.getContent())
                .setPublicationDate(researchDTO.getPublicationDate());

        if(researchDTO.getThumbnail() != null)
        {
            research.setThumbnail(researchDTO.getThumbnail());
        }

        this.researchRepository.save(research);

        this.authorRepository.saveAll(researchDTO
                                              .getAuthors()
                                              .stream()
                                              .map(author ->
                                                           new Author()
                                                                   .setFirstName(author.getFirstName())
                                                                   .setLastName(author.getLastName())
                                                                    .setResearch(research)
                                                  )
                                              .collect(Collectors.toList()));



        return "Research has been stored";
    }

    @Override
    public String update(Long id, ResearchDTO researchDTO)
    throws ResearchNotFoundException
    {
        Research research = this.researchRepository
                .findById(id)
                .orElseThrow(() -> new ResearchNotFoundException(String.format("Research with id: %s could not be found", id)));

        research
                .setTitle(researchDTO.getTitle())
                .setContent(researchDTO.getContent())
                .setPublicationDate(researchDTO.getPublicationDate());

        if(researchDTO.getThumbnail() != null)
        {
            research.setThumbnail(researchDTO.getThumbnail());
        }

        this.researchRepository.save(research);

        return "Research has been updated";
    }

    @Override
    public String delete(Long id)
    throws ResearchNotFoundException
    {
        Research research = this.researchRepository
                .findById(id)
                .orElseThrow(() -> new ResearchNotFoundException(String.format("Research with id: %s could not be found", id)));

        research.getAuthors().stream().forEach(athr -> this.authorRepository.deleteById(athr.getId()));


        if(!research.getThumbnail()
                    .equals("research/no-thumbnail.png"))
        {
            System.out.println("Image is: " + research.getThumbnail());
            this.staticContentService.deleteThumbnailImage(this.jwtUtil.getToken(), new Image().setPath(research.getThumbnail()));
            research.setThumbnail("research/no-thumbnail.png");
            research.setDeleted(true);
            this.researchRepository.save(research);

        } else {
            this.researchRepository.deleteById(research.getId());
        }

        return "Research has been deleted";
    }
}
