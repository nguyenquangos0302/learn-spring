package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.association_mapping.onetomanyandmanytoone.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
}
