package com.feurle.website.usecase.in;

import com.feurle.website.domain.model.Content;
import com.feurle.website.domain.model.ContentId;
import org.springframework.stereotype.Service;

@Service
public interface ArticleQuery {

    Content findByArticleId(ContentId contentId);
}
