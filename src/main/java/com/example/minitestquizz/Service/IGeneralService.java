package com.example.minitestquizz.Service;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

    Page<T> findAllByNameContaining(Pageable pageable, String name);

}
