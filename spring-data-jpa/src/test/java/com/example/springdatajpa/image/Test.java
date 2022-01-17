package com.example.springdatajpa.image;

import com.example.springdatajpa.entity.Employee;
import com.example.springdatajpa.entity.Image;
import com.example.springdatajpa.repository.IEmployeeRepository;
import com.example.springdatajpa.repository.IImageRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    IImageRepository repository;

    @org.junit.Test
    public void contextLoads() {
    }

    @org.junit.Test
    public void testCreateEployee() {
        Image image = new Image();
        image.setId(1);
        image.setName("test");

        File file = new File("/Users/quangnguyen/Downloads/logo.jpeg");
        byte fileContent[] = new byte[(int) file.length()];
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            inputStream.read(fileContent);
            image.setData(fileContent);
            repository.save(image);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
