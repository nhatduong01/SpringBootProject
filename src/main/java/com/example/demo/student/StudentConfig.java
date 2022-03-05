package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig
{
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student duong = new Student(
                    "Duong",
                    LocalDate.of(2001, 8,30),
                    "nhatduong30001@gmail.com"
            );
            Student nguyen  = new Student(
                    "Nguyen",
                    LocalDate.of(2001, 9,30),
                    "nguyen@gmail.com"
            );
            studentRepository.saveAll(List.of(duong,nguyen));
        };
    }
}
