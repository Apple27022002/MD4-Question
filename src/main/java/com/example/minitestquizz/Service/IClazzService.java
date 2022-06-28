package com.example.minitestquizz.Service;

import com.example.minitestquizz.Model.Clazz;

import java.util.Optional;

public interface IClazzService extends IGeneralService<Clazz> {
    Iterable<Clazz> findAll();
    Optional<Clazz> findById(Long id);

}
