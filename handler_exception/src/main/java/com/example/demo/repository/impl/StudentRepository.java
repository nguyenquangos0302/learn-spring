package com.example.demo.repository.impl;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {
    @Override
    public List<StudentModel> findAll() {
        StudentModel student1 = new StudentModel(1, "Quang");
        StudentModel student2 = new StudentModel(2, "Duy");
        //List<StudentModel> list = Arrays.asList(student1, student2);
        List<StudentModel> list = Arrays.asList();
        return list;
    }
}
