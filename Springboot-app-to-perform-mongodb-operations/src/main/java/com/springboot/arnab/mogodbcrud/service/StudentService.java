package com.springboot.arnab.mogodbcrud.service;

import java.util.List;

import com.springboot.arnab.mogodbcrud.model.Student;

public interface StudentService {

    List<Student> findAll();

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpaDesc();

    Student updateStudent(Student student);
    
    Student insertStudent(Student student);

    void deleteStudentById(String id);

}
