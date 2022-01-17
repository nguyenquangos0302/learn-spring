package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.association_mapping.manytomany.Programmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgrammerRepository extends JpaRepository<Programmer, Integer> {
}
