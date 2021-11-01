package com.kravchenko.springmvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {
    @GetMapping({"first/hello","/hello"})
    public String helloPage(HttpServletRequest request){
        String name=request.getParameter("name");
        String surname= request.getParameter("surname");

        System.out.println("Hi, "+ name+" "+surname);

        return "first/hello";
    }


    @GetMapping({"first/bye","/bye"})
    public String byePage(@RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "surname", required = false) String surname,
                          Model model){

        String message="Bye, "+name+" "+surname;
        model.addAttribute("message", message);

        return "first/bye";
    }

    @GetMapping({"first/calc","/calc"})
    public String doCalculate(@RequestParam("a") int inA,
                              @RequestParam("b") int inB,
                              @RequestParam("type") String inType,
                              Model model){

        float res=0;
        switch(inType){
            case "add":
                res=inA+inB;
                break;
            case "sub":
                res=inA-inB;
                break;
            case "mult":
                res=inA*inB;
                break;
            case "div":
                res=inA/inB;
                break;
        }

        String resultStr=inType+", result: "+res;
        model.addAttribute("resMessage",resultStr);

        return "first/calc";

    }
}
