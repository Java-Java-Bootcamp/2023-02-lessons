package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {
    @Value("${hello}")
    private String hello;

    @GetMapping("hello")
    public String index() {
        return "index";
    }
}
