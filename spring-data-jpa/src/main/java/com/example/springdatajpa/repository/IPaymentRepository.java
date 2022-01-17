package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.inheritant_mapping.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
}
