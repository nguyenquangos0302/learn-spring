package com.example.demo.api;

import com.example.demo.exception.ApiRequestException;
import com.example.demo.model.StudentModel;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentApi {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/list")
    public ResponseEntity<List<StudentModel>> findAll() {
        try {
            List<StudentModel> list = studentService.findAll();
            if (list.size() == 0) {
                throw new ApiRequestException("Not found list student");
            }
            return new ResponseEntity<List<StudentModel>>(list, HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException("Not found list student");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<StudentModel>> findStudentById(@PathVariable int id) {
        try {
            StudentModel studentModel = new StudentModel();
            studentModel.setId(id);
            List<StudentModel> list = studentService.findStudentById(studentModel);
            if (list.size() == 0) {
                throw new ApiRequestException("Not found student with " + id);
            }
            return new ResponseEntity<List<StudentModel>>(list, HttpStatus.OK);
        } catch (ApiRequestException e) {
            throw new ApiRequestException("Not found student with " + id);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
