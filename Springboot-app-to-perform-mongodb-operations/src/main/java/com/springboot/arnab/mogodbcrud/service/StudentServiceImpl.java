package com.springboot.arnab.mogodbcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.arnab.mogodbcrud.model.Student;
import com.springboot.arnab.mogodbcrud.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByStudentNumber(long studentNumber) {
        return studentRepository.findByStudentNumber(studentNumber);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public List<Student> findAllByOrderByGpaDesc() {
        return studentRepository.findAllByOrderByGpaDesc();
    }

    @Override
    public Student insertStudent(Student student)
    {
    	Student s=findByStudentNumber(student.getStudentNumber());
    	if(s==null)
    	{
    		return studentRepository.insert(student);
    	}
    	else
    	{
    		return null;
    	}
    }
    
    @Override
    public Student updateStudent(Student student) {
    	Student s=findByStudentNumber(student.getStudentNumber());
    	if(s!=null)
    	{
    		student.setId(s.getId());
    		return studentRepository.save(student);
    	}
    	else
    	{
    		return null;
    	}
    }

    @Override
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }
}
