package com.example.springdatajpa.caching;

import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.repository.IEmployeeRepository;
import org.hibernate.Session;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    IEmployeeRepository iEmployeeRepository;


    @org.junit.Test
    public void contextLoads() {

    }

    @org.junit.Test
    @Transactional
    public void get() {
        Employee e = iEmployeeRepository.findById(UUID.fromString("272e96b2-ec51-40b3-bb75-fb459dc5ed29")).orElse(null);

        iEmployeeRepository.findById(UUID.fromString("272e96b2-ec51-40b3-bb75-fb459dc5ed29"));
    }

}
