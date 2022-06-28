package com.example.minitestquizz.Service.impl;

import com.example.minitestquizz.Model.Answer;
import com.example.minitestquizz.Model.Question;
import com.example.minitestquizz.Repository.QuestionRepository;
import com.example.minitestquizz.Service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Override
    public Iterable<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }


    @Override
    public void save(Question question) {
        questionRepository.save(question);

    }

    @Override
    public void remove(Long id) {
        questionRepository.deleteById(id);

    }
}
