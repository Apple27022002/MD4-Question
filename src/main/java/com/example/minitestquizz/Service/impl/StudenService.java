package com.example.minitestquizz.Service.impl;

import com.example.minitestquizz.Model.Student;
import com.example.minitestquizz.Repository.StudentRepository;
import com.example.minitestquizz.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;
@Service
public class StudenService implements IStudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Page<Student> findAllByNameContaining(Pageable pageable, String name) {
        return studentRepository.findAllByNameContaining(pageable,name);
    }

    @Override
    public Page<Student> findAllByScoreGreaterThan8(Pageable pageable, Double score) {
        return null;
    }

    @Override
    public Iterable<Class> findAllByClazzId(Long id) {
        return studentRepository.findAllByClazzId(id);
    }

    @Override
    public Iterable<Student> findAllScoreBetween(Double from, Double to) {
        return studentRepository.findAllByScoreBetween(from,to);
    }
}
