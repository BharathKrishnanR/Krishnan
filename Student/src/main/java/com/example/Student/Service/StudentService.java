package com.example.Student.Service;

import com.example.Student.Dto.StudentUpdateDTO;
import com.example.Student.Repository.StudentRepository;
import com.example.Student.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository, StudentRepository studentRepository1) {
        this.studentRepository = studentRepository1;
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

        studentRepository.delete(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudentPartial(Long id, StudentUpdateDTO dto) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (dto.getFirstName() != null) {
            student.setFirstName(dto.getFirstName());
        }

        if (dto.getLastName() != null) {
            student.setLastName(dto.getLastName());
        }

        if (dto.getEmail() != null) {
            student.setEmail(dto.getEmail());
        }

        return studentRepository.save(student);
    }
}
