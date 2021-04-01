package com.example.demo.repository;

import com.example.demo.model.StudentModel;

import java.util.List;

public interface IStudentRepository {

    List<StudentModel> findAll();

}
