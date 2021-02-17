package com.bootbasic.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentApi {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public List<Student> hello() {
        return studentService.getList();
    }

    @PostMapping("")
    public Student registerNewStudent(@RequestBody Student student) {
        return studentService.registerNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudeng(id);
    }


}
