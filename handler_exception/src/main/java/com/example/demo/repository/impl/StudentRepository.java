package com.example.demo.repository.impl;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<StudentModel> findStudentById(StudentModel studentModel) {
        StudentModel student1 = new StudentModel(1, "Quang");
        StudentModel student2 = new StudentModel(2, "Duy");
        List<StudentModel> list = Arrays.asList(student1, student2);
        List<StudentModel> list1 = new ArrayList<StudentModel>();
        for (StudentModel studentModel1 : list) {
            if (studentModel1.getId() == studentModel.getId()) {
                list1.add(studentModel1);
            }
        }
        return list1;
    }

}
