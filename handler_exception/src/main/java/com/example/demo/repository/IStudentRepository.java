package com.example.demo.repository;

import com.example.demo.model.StudentModel;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository {

    List<StudentModel> findAll();

    List<StudentModel> findStudentById(StudentModel studentModel);

}
