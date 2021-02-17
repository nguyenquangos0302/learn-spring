package com.bootbasic.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getList() {
        return studentRepository.findAll();
    }

    public Student registerNewStudent(Student student) {
        Optional<Student> student1 = studentRepository.findStudentByEmail(student.getEmail());
        if (student1.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        return studentRepository.save(student);
    }

    public void deleteStudeng(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Error");
        }
        studentRepository.deleteById(id);
    }
}
