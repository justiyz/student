package com.springsecurity1.springsecurity1.data.repositories;

import com.springsecurity1.springsecurity1.data.exceptions.StudentNotFoundException;
import com.springsecurity1.springsecurity1.data.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
