package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/{lang}")
public class HomeController {
    @GetMapping(
            value = "/home",
            name = "home_index"
    )
    public String index() {
        return "home/index";
    }
}
