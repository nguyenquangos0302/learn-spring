package com.enumjpa.demo;

import com.enumjpa.demo.entity.Article;
import com.enumjpa.demo.entity.EStatus;
import com.enumjpa.demo.entity.EType;
import com.enumjpa.demo.entity.IArticleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(IArticleRepository articleRepository) {
        Article article1 = new Article(
                1L,
                "ordinal title",
                EStatus.OPEN,
                EType.EXTERNAL);
        articleRepository.save(article1);
        return null;
    }

}
