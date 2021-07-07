package com.example.springdatajpa.jpql;

import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.repository.IEmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpqlTest {

    @Autowired
    IEmployeeRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void Test01() {
        List<Employee> list = repository.findAll();
        list.forEach(data -> System.out.println(data.getName()));
    }

    @Test
    public void Test02() {
        List<Employee> list = repository.findByName("John");
        list.forEach(data -> System.out.println(data.getName()));
    }

    @Test
    public void Test03() {
        List<Employee> list = repository.findByScoreGiven(30, 60);
        list.forEach(data -> System.out.println(data.getName()));
    }

    @Test
    public void Test04() {
        List<Employee> list = repository.findByScoreBetween(30, 60);
        list.forEach(data -> System.out.println(data.getName()));
    }


}
