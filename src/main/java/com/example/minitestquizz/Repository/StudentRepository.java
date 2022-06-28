package com.example.minitestquizz.Repository;

import com.example.minitestquizz.Model.Clazz;
import com.example.minitestquizz.Model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Page<Student> findAllByNameContaining(Pageable pageable, String name);

    Page<Student> findAllByScoreGreaterThan(Pageable pageable, Double score);

    Iterable<Class> findAllByClazzId(Long id);

    Iterable<Student> findAllByScoreBetween(Double from, Double to);
}
