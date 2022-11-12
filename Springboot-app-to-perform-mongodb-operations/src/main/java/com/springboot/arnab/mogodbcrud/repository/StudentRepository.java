package com.springboot.arnab.mogodbcrud.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.arnab.mogodbcrud.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpaDesc();

}