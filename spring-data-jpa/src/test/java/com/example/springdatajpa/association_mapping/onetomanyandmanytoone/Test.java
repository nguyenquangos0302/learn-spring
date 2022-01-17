package com.example.springdatajpa.association_mapping.onetomanyandmanytoone;

import com.example.springdatajpa.entity.association_mapping.onetomanyandmanytoone.Customer;
import com.example.springdatajpa.entity.association_mapping.onetomanyandmanytoone.PhoneNumber;
import com.example.springdatajpa.entity.component_mapping.Address;
import com.example.springdatajpa.entity.component_mapping.Employee2;
import com.example.springdatajpa.repository.ICustomerRepository;
import com.example.springdatajpa.repository.IEmployee2Repository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    ICustomerRepository repository;

    @org.junit.Test
    public void contextLoads() {
    }

    @org.junit.Test
    public void testCreateEployee() {
        Customer customer = new Customer();
        customer.setName("john");

//        Set<PhoneNumber> list = new HashSet<>();

        PhoneNumber ph = new PhoneNumber();
        ph.setNumber("1");
        ph.setType("ok");
//        ph.setCustomer(customer);

//        list.add(ph);
//
//        customer.setNumbers(list);
        customer.addPhoneNumber(ph);

        repository.save(customer);

    }

    @org.junit.Test
    public void callCustomer() {
        Customer cusomter = repository.findById(4L).orElse(null);
        Set<PhoneNumber> list = cusomter.getNumbers();
        System.out.println(list);

    }

}
