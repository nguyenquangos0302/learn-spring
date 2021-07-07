package com.example.springdatajpa.idgenerate;

import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.repository.IEmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    @Autowired
    IEmployeeRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testCreateEployee() {

        Employee employee = new Employee();
        employee.setName("John");

        repository.save(employee);
    }

}
