package com.example.springdatajpa.componentmapping;

import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.entity.component_mapping.Address;
import com.example.springdatajpa.entity.component_mapping.Employee2;
import com.example.springdatajpa.repository.IEmployee2Repository;
import com.example.springdatajpa.repository.IEmployeeRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    IEmployee2Repository repository;

    @org.junit.Test
    public void contextLoads() {
    }

    @org.junit.Test
    public void testCreateEployee() {

        Employee2 employee = new Employee2();
        Address address = new Address();
        address.setCity("hcm");
        address.setStreetAddress("456");
        address.setCountry("vn");
        address.setState("texas");
        address.setZipcode("0123");
        employee.setId(123);
        employee.setAddress(address);
        employee.setName("John");

        repository.save(employee);
    }

}
