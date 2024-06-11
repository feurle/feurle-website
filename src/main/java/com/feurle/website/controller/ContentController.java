package com.feurle.website.controller;


import com.feurle.website.domain.Content;
import com.feurle.website.domain.ContentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class ContentController {

    private final ContentRepository contentRepository;

    public ContentController(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @GetMapping("/contents")
    Collection<Content> contents() {
        return contentRepository.findAll();
    }

}
