package com.example.demo.student;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService
{
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents()
    {
        return  studentRepository.findAll();
    }

    public void addNewStudent(Student newStudent)
    {
        Optional<Student> studentWithEmail =  studentRepository.
                findStudentByEmail(newStudent.getEmail());
        if(studentWithEmail.isPresent())
        {
            throw  new IllegalStateException("Email is already existed");
        }
        studentRepository.save(newStudent);
        System.out.println(newStudent);
    }

    public void deleteStudent(long id)
    {
        boolean isExisted = studentRepository.existsById(id);
        if(!isExisted)
        {
            throw  new IllegalStateException("Student with ID " +id + " does not exist");
        }
        studentRepository.deleteById(id);
    }
    @Transactional
    public void updateStudent(long studentID, String name, String email)
    {
        Student student = studentRepository.findById(studentID).orElseThrow(
                () -> new IllegalStateException("Student with ID " +studentID + " does not exist")
        );
        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name))
        {
            student.setName(name);
        }
        if(email != null && email.length() > 0 && !Objects.equals(email, student.getEmail()))
        {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent())
            {
                throw  new IllegalStateException("The email is taken !!!");
            }
            student.setEmail(email);
        }
    }
}
