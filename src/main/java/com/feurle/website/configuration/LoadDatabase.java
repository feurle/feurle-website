package com.feurle.website.configuration;

import com.feurle.website.domain.Content;
import com.feurle.website.domain.ContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
@Slf4j
public class LoadDatabase {


    @Bean
    CommandLineRunner initDatabase(ContentRepository repository) {
        return args -> {
            log.info("Preloading {}", repository.save(Content.builder().contentTitle("My Second Title")
                    .contentText("Wurzelschlabber wippelzwicker fratzelgrüppel")
                    .creationDate(Instant.parse("2024-02-28T10:00:00.000Z"))
                    .build()));
            log.info("Preloading {}",repository.save(Content.builder().contentTitle("My First Title")
                    .contentText("Gampfus trollige Bätschel seimeln")
                    .creationDate(Instant.parse("2024-02-13T17:00:00.000Z"))
                    .build()));
        };
    }

}
