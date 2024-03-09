package com.feurle.website.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleEntity,Long> {
}
