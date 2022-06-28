package com.example.minitestquizz.Service;

import com.example.minitestquizz.Model.Answer;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
