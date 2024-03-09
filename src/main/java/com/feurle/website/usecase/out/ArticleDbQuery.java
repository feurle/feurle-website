package com.feurle.website.usecase.out;

import com.feurle.website.domain.model.Content;
import com.feurle.website.domain.model.ContentId;

public interface ArticleDbQuery {

    Content findByArticleId(ContentId contentId);
}
