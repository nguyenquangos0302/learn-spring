package com.example.springdatajpa.pagingandsort;

import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.repository.IEmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.query.AbstractJpaQuery;
import org.springframework.data.jpa.repository.query.JpaParametersParameterAccessor;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test01 {

    @Autowired
    IEmployeeRepository repository;

    @PersistenceContext
    private EntityManager em;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testPaging() {
        Page<Employee> listEmployee = repository.findAll(PageRequest.of(1, 2));
        System.out.println(listEmployee.getTotalPages() + " " + listEmployee.getTotalElements());
        listEmployee.forEach(data -> System.out.println(data.getName()));
    }

    @Test
    public void testSort() {
        //List<Employee> employeeList = repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        //List<Employee> employeeList = repository.findAll(Sort.by(Sort.Direction.ASC, "name", "id"));
        //List<Employee> employeeList = repository.findAll(Sort.by("name"));
        //List<Employee> employeeList = repository.findAll(Sort.by("name").descending().and(Sort.by("id")));
        List<Employee> employeeList = repository.findAll(Sort.by("name").descending().and(Sort.by("id")).ascending());
        employeeList.forEach(data -> System.out.println(data.getName()));
    }

    @Test
    public void testOrder() {
        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "name");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "id");
        orders.add(order1);
        orders.add(order2);
        List<Employee> employeeList = repository.findAll(Sort.by(orders));
        employeeList.forEach(data -> System.out.println(data.getName()));
    }

    @Test
    public void testPagingAndSort() {
        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "name");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "id");
        orders.add(order1);
        orders.add(order2);
        Page<Employee> employeesPages = repository.findAll(PageRequest.of(3, 2, Sort.by(orders)));
        employeesPages.forEach(data -> System.out.println(data.getName()));
    }

    @Test
    public void testPagingAndSort1() {
        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "name");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "id");
        orders.add(order1);
        orders.add(order2);
        Page<Employee> employeesPages = repository.findByNameLike("a", PageRequest.of(3, 2, Sort.by(orders)));
        employeesPages.forEach(data -> System.out.println(data.getName()));
    }

    private String buildCredentical(Map<String, Object> creditical) {
        StringBuilder sp = new StringBuilder(" WHERE 1 = 1");
        if (creditical.containsKey("name")) {
            sp.append(" AND name = '" + creditical.get("name") + "' ");
        }
        if (creditical.containsKey("emp_id")) {
            sp.append(" AND emp_id = '" + creditical.get("emp_id") + "' ");
        }
        return sp.toString();
    }

    @Test
    public void testCustomeQuery() {
        Map<String, Object> creditical = new HashMap<>();
        creditical.put("name", "John");
        creditical.put("emp_id", "272e96b2-ec51-40b3-bb75-fb459dc5ed29");
        Query query = em.createNativeQuery("SELECT * FROM employee" + buildCredentical(creditical), Employee.class);
        List<Employee> list = new ArrayList<>();
        list = query.getResultList();
        for (Employee employee : list) {
            System.out.println(employee.getName());
        }
    }

}
