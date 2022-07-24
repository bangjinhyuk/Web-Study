package com.example.webthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by bangjinhyuk on 2022/07/24.
 */
@Controller
public class HomeController {

    @GetMapping
    public String index(){
        return "index";
    }
}
