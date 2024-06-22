package com.example.cashcardservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase
{
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CashCardRepository cashCardRepository){
        return args -> {
            log.info("Preloading "+ cashCardRepository.save(new CashCard(100,"Frodo")));
            log.info("Preloading "+ cashCardRepository.save(new CashCard(125,"Gando")));
            log.info("Preloading "+ cashCardRepository.save(new CashCard(178,"Mando")));
        };
    }
}
