package com.feurle.website.model;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "content", path = "content")
public interface ContentRepository extends JpaRepository<Content,Long> {
}
