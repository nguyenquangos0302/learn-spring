package com.example.springdatajpa.association_mapping.manytomany;

import com.example.springdatajpa.entity.association_mapping.manytomany.Programmer;
import com.example.springdatajpa.entity.association_mapping.manytomany.Project;
import com.example.springdatajpa.repository.IProgrammerRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    IProgrammerRepository programmerRepository;

    @org.junit.Test
    public void contextLoads() {
    }

    @org.junit.Test
    public void create() {
        Programmer programmer = new Programmer();
        programmer.setName("A");
        programmer.setSal(1);

        Set<Project> prj = new HashSet<>();

        Project project = new Project();
        project.setName("PA");

        prj.add(project);

        programmer.setProjects(prj);

        programmerRepository.save(programmer);

    }

}
