package com.example.springdatajpa.nativequery;

import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.repository.IEmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NativeQueryTest {

    @Autowired
    IEmployeeRepository repository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void Test01() {
        List<Employee> list = repository.findAllEmployee(PageRequest.of(0, 2));
        list.forEach(data -> System.out.println(data.getName()));
    }

    @Test
    public void Test02() {
        List<Employee> list = repository.findByEmployeeName("john");
        list.forEach(data -> System.out.println(data.getName()));
    }

}
