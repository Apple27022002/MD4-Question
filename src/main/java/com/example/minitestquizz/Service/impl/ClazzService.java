package com.example.minitestquizz.Service.impl;

import com.example.minitestquizz.Model.Clazz;
import com.example.minitestquizz.Repository.ClazzRepository;
import com.example.minitestquizz.Service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;
@Service
public class ClazzService implements IClazzService {
    @Autowired
    ClazzRepository clazzRepository;



    @Override
    public Iterable<Clazz> findAll() {
        return clazzRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return clazzRepository.findById(id);
    }

    @Override
    public void save(Clazz clazz) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Page<Clazz> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }

}
