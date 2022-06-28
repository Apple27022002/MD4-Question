package com.example.minitestquizz.Service.impl;

import com.example.minitestquizz.Model.Answer;
import com.example.minitestquizz.Repository.AnswerRepository;
import com.example.minitestquizz.Service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService implements IAnswerService {
    @Autowired
    AnswerRepository answerRepository;
    @Override
    public Iterable<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> findById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public void save(Answer answer) {
        answerRepository.save(answer);

    }

    @Override
    public void remove(Long id) {
        answerRepository.deleteById(id);

    }
}
