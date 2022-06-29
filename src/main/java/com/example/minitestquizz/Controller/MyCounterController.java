package com.example.minitestquizz.Controller;

import com.example.minitestquizz.Model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("mycounter")
public class MyCounterController {

        /* add MyCounter in model attribute */
        @ModelAttribute("mycounter")
        public MyCounter setUpCounter() {
            return new MyCounter();
        }

        @GetMapping("/")
        public String get(@ModelAttribute("mycounter") MyCounter myCounter) {
            myCounter.increment();
            return "index";
    }
}