package com.springsecurity1.springsecurity1.web.controller.student;

import com.springsecurity1.springsecurity1.data.exceptions.StudentNotFoundException;
import com.springsecurity1.springsecurity1.data.model.Student;
import com.springsecurity1.springsecurity1.data.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
    @RequestMapping("/api/auth")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @CrossOrigin
    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) throws StudentNotFoundException {
        Student student1 = studentRepository.save(student);
        return student1;
    }

    @CrossOrigin
    @GetMapping("/student")
    public Page<Student> listOfStudents (Pageable pageable){
        return studentRepository.findAll(pageable);
    }

    @CrossOrigin
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id){
        Student student;
        student = studentRepository.findById(id).orElse(null);
        return student;
    }

    @CrossOrigin
    @PutMapping("student")
    public Student updateStudent(Student student){
        studentRepository.save(student);
        return student;
    }

    @CrossOrigin
    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) throws StudentNotFoundException {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student);
                    return ResponseEntity.ok().build();
                }).orElseThrow(()  -> new StudentNotFoundException("student with the id"+id+"not found"));
    }




}
