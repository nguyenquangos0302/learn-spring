package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.association_mapping.manytomany.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {



}
