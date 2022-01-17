package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.association_mapping.manytomany.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {



}
