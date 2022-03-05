package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController
{
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents()
    {
        return studentService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student newStudent)
    {
        studentService.addNewStudent(newStudent);
    }
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") long id){
        studentService.deleteStudent(id);
    }
    @PutMapping(path = "{studentID}")
    public void updateStudent(
            @PathVariable("studentID") long studentID,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    )
    {
        studentService.updateStudent(studentID, name, email);
    }
}
