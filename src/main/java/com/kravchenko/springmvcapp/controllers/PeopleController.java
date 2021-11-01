package com.kravchenko.springmvcapp.controllers;

import com.kravchenko.springmvcapp.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDao personDao;


    @Autowired
    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping()
    public String index(Model model) throws SQLException {
        //все люди из DAO и в отображение
        model.addAttribute("people",personDao.index());
        return "people/page";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int inId, Model model){

        model.addAttribute("person",personDao.show(inId));
        return "people/show";
    }
}
