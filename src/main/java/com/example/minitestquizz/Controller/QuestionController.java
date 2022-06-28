package com.example.minitestquizz.Controller;

import com.example.minitestquizz.Model.Answer;
import com.example.minitestquizz.Model.Question;
import com.example.minitestquizz.Service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/quests")
@Controller
public class QuestionController {
    @Autowired
    IQuestionService iQuestionService;

    @GetMapping//Tìm
    public ResponseEntity<Iterable<Question>> findAll() {
        return new ResponseEntity<>(iQuestionService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Question> findProductById(@PathVariable Long id) {
        Optional<Question> questionOptional = iQuestionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionOptional.get(), HttpStatus.OK);
    }




    @PostMapping("")//Add-Thêm-RequestBody để lấy product trực tiếp từ web về để dùng
    public ResponseEntity add(@RequestBody Question question) {
        iQuestionService.save(question);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/{id}")//EDIT-Sửa
    public ResponseEntity<Question> update(@PathVariable Long id, @RequestBody Question question) {
        Optional<Question> questionOptional = iQuestionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        question.setId(questionOptional.get().getId());
        iQuestionService.save(question);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")//Delete-Xóa
    public ResponseEntity<Question> delete(@PathVariable Long id) {
        Optional<Question> questionOptional = iQuestionService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iQuestionService.remove(id);
        return new ResponseEntity<>(questionOptional.get(), HttpStatus.OK);
    }
}
