package com.example.minitestquizz.Controller;

import com.example.minitestquizz.Model.Student;
import com.example.minitestquizz.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @GetMapping
    public ResponseEntity<Iterable<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity add(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> questionOptional = studentService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        student.setId(questionOptional.get().getId());
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")//Delete-Xóa
    public ResponseEntity<Student> delete(@PathVariable Long id) {
        Optional<Student> questionOptional = studentService.findById(id);
        if (!questionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentService.remove(id);
        return new ResponseEntity<>(questionOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/search-by-name")
    public ResponseEntity<Iterable<Student>> findAllByNameContaining(@RequestParam String name,@PageableDefault(size = 3) Pageable pageable) {
        return new ResponseEntity<>(studentService.findAllByNameContaining(pageable, name), HttpStatus.OK);
    }

}
