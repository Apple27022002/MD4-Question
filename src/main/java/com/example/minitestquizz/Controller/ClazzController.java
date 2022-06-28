package com.example.minitestquizz.Controller;


import com.example.minitestquizz.Service.IClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/classes")
public class ClazzController {
        @Autowired
        IClazzService iClazzService;
//
//        @GetMapping
//        public ResponseEntity<Iterable<Clazz>> findAll() {
//            return new ResponseEntity<>(iClazzService.findAll(), HttpStatus.OK);
//        }
}
