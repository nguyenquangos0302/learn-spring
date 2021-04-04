package com.example.demo.service.impl;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.IStudentRepository;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<StudentModel> findAll() throws Exception {
        return studentRepository.findAll();
    }

    @Override
    public List<StudentModel> findStudentById(StudentModel studentModel) throws Exception {
        return studentRepository.findStudentById(studentModel);
    }
}
