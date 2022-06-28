package com.example.minitestquizz.Controller;

import com.example.minitestquizz.Model.Answer;
import com.example.minitestquizz.Model.Question;
import com.example.minitestquizz.Service.IAnswerService;
import com.example.minitestquizz.Service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/answers")
@Controller
public class AnswerController {
    @Autowired
    IAnswerService iAnswerService;

    @Autowired
    IQuestionService iQuestionService;


    @GetMapping//Tìm
    public ResponseEntity<Iterable<Answer>> findAll() {
        return new ResponseEntity<>(iAnswerService.findAll(), HttpStatus.OK);
    }



    @PostMapping("")//Add-Thêm-RequestBody để lấy product trực tiếp từ web về để dùng
    public ResponseEntity add(@RequestBody Answer answer) {
        iAnswerService.save(answer);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/{id}")//EDIT-Sửa
    public ResponseEntity<Answer> update(@PathVariable Long id, @RequestBody Answer answer) {
        Optional<Answer> answerOptional = iAnswerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        answer.setId(answerOptional.get().getId());
        iAnswerService.save(answer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")//Delete-Xóa
    public ResponseEntity<Answer> delete(@PathVariable Long id) {
        Optional<Answer> answerOptional = iAnswerService.findById(id);
        if (!answerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iQuestionService.remove(id);
        return new ResponseEntity<>(answerOptional.get(), HttpStatus.OK);
    }
}
