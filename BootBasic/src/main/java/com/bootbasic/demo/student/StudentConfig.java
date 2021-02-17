package com.bootbasic.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            List<Student> list = new ArrayList<Student>();
            Student marry = new Student("Maria", "maria@gmail.com", LocalDate.of(2000, Month.JANUARY, 5));
            list.add(marry);
            studentRepository.saveAll(list);
        };

    }

}
