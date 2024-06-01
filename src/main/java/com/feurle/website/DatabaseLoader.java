package com.feurle.website;

import com.feurle.website.model.Content;
import com.feurle.website.model.ContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Slf4j
@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ContentRepository contentRepository;

    public DatabaseLoader(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Content content1 = Content.builder().contentTitle("My First Title")
                .contentText("Gampfus trollige Bätschel seimeln")
                .creationDate(Instant.parse("2024-02-13T17:00:00.000Z"))
                .build();
        contentRepository.save(content1);

        Content content2 = Content.builder().contentTitle("My Second Title")
                .contentText("Wurzelschlabber wippelzwicker fratzelgrüppel")
                .creationDate(Instant.parse("2024-02-28T10:00:00.000Z"))
                .build();
        contentRepository.save(content2);

        contentRepository.findAll().forEach(content -> log.info("Content: {}", content));
    }
}
