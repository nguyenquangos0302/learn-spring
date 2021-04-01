package com.example.demo.service;

import com.example.demo.model.StudentModel;

import java.util.List;

public interface IStudentService {

    List<StudentModel> findAll() throws Exception;

}
