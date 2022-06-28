package com.example.minitestquizz.Service;

import com.example.minitestquizz.Model.Student;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface IStudentService extends IGeneralService<Student>{
    Page<Student> findAllByScoreGreaterThan8(Pageable pageable, Double score);

    Iterable<Class> findAllByClazzId(Long id);

    Iterable<Student> findAllScoreBetween(Double from, Double to);
}
