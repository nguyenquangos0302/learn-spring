package com.example.springdatajpa;

import com.example.springdatajpa.entity.association_mapping.manytomany.Book;
import com.example.springdatajpa.entity.association_mapping.manytomany.BookPublisher;
import com.example.springdatajpa.entity.association_mapping.manytomany.Publisher;
import com.example.springdatajpa.repository.BookRepository;
import com.example.springdatajpa.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataJpaApplication implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public static void main(String[] args) {

        SpringApplication.run(SpringDataJpaApplication.class, args);

    }

    @Override
    public void run(String... args) {
        // Create a couple of Book, Publisher and BookPublisher
        Publisher publisherA = new Publisher("Publisher A");
        Publisher publisherB = new Publisher("Publisher B");
        Publisher publisherC = new Publisher("Publisher C");
        publisherRepository.saveAll(Arrays.asList(publisherA, publisherB, publisherC));

        BookPublisher bookPublisher1 = new BookPublisher();
        bookPublisher1.setPublisher(publisherA);

        BookPublisher bookPublisher2 = new BookPublisher();
        bookPublisher2.setPublisher(publisherB);

        BookPublisher bookPublisher3 = new BookPublisher();
        bookPublisher3.setPublisher(publisherC);

        Book book1 = new Book();
        book1.setName("Book 1");
        book1.addPublisher(bookPublisher1);
        book1.addPublisher(bookPublisher3);

        Book book2 = new Book();
        book2.setName("Book 2");
        book2.addPublisher(bookPublisher2);

        bookRepository.saveAll(Arrays.asList(book1, book2));
    }

}
