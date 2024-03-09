package com.feurle.website.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Content {


    @Id
    private Long id;

    private String content;

}
