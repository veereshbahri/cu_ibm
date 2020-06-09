package com.example.todo_app.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    public String home()
    {
        return "index";
    }
}
