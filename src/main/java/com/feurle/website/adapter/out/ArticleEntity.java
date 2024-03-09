package com.feurle.website.adapter.out;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "T_ARTICLE")
@Data
public class ArticleEntity {

    @Id
    private Long id;

    private String title;

    private String text;
}
