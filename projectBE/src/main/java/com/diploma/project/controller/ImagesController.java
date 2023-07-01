package com.diploma.project.controller;

import com.diploma.project.dto.ImagesDTO;
import com.diploma.project.model.Images;
import com.diploma.project.security.ImagesRequest;
import com.diploma.project.service.ImagesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
