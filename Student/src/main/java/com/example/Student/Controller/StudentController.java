package com.example.Student.Controller;

import com.example.Student.Service.StudentService;
import com.example.Student.entity.Student;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
    public Student create(@Valid @RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // GET ALL
    @GetMapping
    public List<Student> getAll() {
        return studentService.getAllStudents();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    // UPDATE
    @PutMapping
    public Student update(@Valid @RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "Student deleted successfully";
    }
}