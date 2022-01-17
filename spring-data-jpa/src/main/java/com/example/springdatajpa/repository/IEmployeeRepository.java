package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, UUID> {


    Page<Employee> findAll(Pageable pageable);

    @Query("from Employee")
    List<Employee> findAll();

    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> findAllEmployee(Pageable pageable);

    Page<Employee> findByNameLike(String name, Pageable pageable);

    @Query("from Employee as e where e.name = :name")
    List<Employee> findByName(@Param("name") String name);

    @Query("from Employee as e where e.score >= :min and e.score <= :max")
    List<Employee> findByScoreGiven(@Param("min") int min, @Param("max") int max);

    List<Employee> findByScoreBetween(int min, int max);

    @Query(value = "SELECT * FROM employee where name = :name", nativeQuery = true)
    List<Employee> findByEmployeeName(@Param("name") String name);

}
