package com.feurle.website.domain.service;

import com.feurle.website.domain.model.Content;
import com.feurle.website.domain.model.ContentId;

import java.util.ArrayList;
import java.util.List;

public class ContentManagementService {

    Content findArticleById(ContentId contentId) {
        return new Content(contentId);
    }
    List<Content> findAllArticles() {
        return new ArrayList<>();
    }
}
