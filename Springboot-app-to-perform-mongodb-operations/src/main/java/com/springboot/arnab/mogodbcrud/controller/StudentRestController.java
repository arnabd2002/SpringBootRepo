package com.springboot.arnab.mogodbcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.arnab.mogodbcrud.model.Student;
import com.springboot.arnab.mogodbcrud.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/")
    public List<Student> getAllStudents() {
    	
        return studentService.findAll();
    }

    @GetMapping(value = "/byStudentNumber/{studentNumber}")
    public Student getStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber) {
        return studentService.findByStudentNumber(studentNumber);
    }

    @GetMapping(value = "/byEmail/{email}")
    public Student getStudentByEmail(@PathVariable("email") String email) {
        return studentService.findByEmail(email);
    }

    @GetMapping(value = "/orderByGpa")
    public List<Student> findAllByOrderByGpaDesc() {
        return studentService.findAllByOrderByGpaDesc();
    }

    @PostMapping(value = "/insert")
    public ResponseEntity<?> insertStudent(@RequestBody Student student) {
    	
    	Student newStudent=studentService.insertStudent(student);
    	if(newStudent==null)
    	{
    		return new ResponseEntity<String>("Student already exists.",HttpStatus.BAD_REQUEST);
    	}
    	else
    	{
    		return new ResponseEntity<Student>(newStudent,HttpStatus.OK);
    	}
    }
    
    @PostMapping(value = "/save")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
    	Student newStudent=studentService.updateStudent(student);
    	if(newStudent!=null)
    	{
    		return new ResponseEntity<Student>(newStudent,HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<String>("Student data update failed",HttpStatus.BAD_REQUEST);
    	}
    }

    @DeleteMapping(value = "/delete/{studentNumber}")
    public ResponseEntity<?> deleteStudentByStudentNumber(@PathVariable long studentNumber) {
        studentService.deleteStudentById(studentService.findByStudentNumber(studentNumber).getId());
        return new ResponseEntity<String>("Student deleted successfully", HttpStatus.OK);
    }

}
