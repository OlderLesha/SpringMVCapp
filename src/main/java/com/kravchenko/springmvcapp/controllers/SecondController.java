package com.kravchenko.springmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {
    @GetMapping({"second/exit","/exit"})
    public String exitPage(){
        return "second/exit";
    }
}
