package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.component_mapping.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployee2Repository extends JpaRepository<Employee2, Integer> {
}
