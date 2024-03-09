package com.feurle.website.adapter.out;

import com.feurle.website.domain.model.Content;
import com.feurle.website.domain.model.ContentId;
import com.feurle.website.usecase.out.ArticleDbQuery;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticlePersistenceAdapter implements ArticleDbQuery {

    private final ArticleRepository articleRepository;

    @Override
    public Content findByArticleId(ContentId contentId) {
        ArticleEntity articleEntity = articleRepository.findById(contentId.value()).orElseThrow(EntityNotFoundException::new);
        return null;
    }
}
