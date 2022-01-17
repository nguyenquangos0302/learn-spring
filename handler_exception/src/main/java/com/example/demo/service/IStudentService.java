package com.example.demo.service;

import com.example.demo.model.StudentModel;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    List<StudentModel> findAll() throws Exception;

    List<StudentModel> findStudentById(StudentModel studentModel) throws Exception;

}
