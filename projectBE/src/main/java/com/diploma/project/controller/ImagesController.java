package com.diploma.project.controller;

import com.diploma.project.dto.ImagesDTO;
import com.diploma.project.model.Images;
import com.diploma.project.security.ImagesRequest;
import com.diploma.project.service.ImagesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/images")
public class ImagesController extends GenericController<Images, ImagesDTO>{
    ImagesController(ImagesService imagesService) {
        super(imagesService);
    }

    @PostMapping("/save")
    public ImagesDTO saveRequest(@RequestBody ImagesRequest imagesRequest){
        return ((ImagesService) getGenericService()).saveRequest(imagesRequest);
    }

    @GetMapping("/find")
    public List<ImagesDTO> findImagesByMarketplaceService_Id(@RequestParam Long id){
        return ((ImagesService) getGenericService()).findImagesByMarketplaceService_Id(id);
    }
}
