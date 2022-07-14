package com.example.demo.web;

import com.example.demo.domain.book;
import com.example.demo.service.bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class bookcontroller {
    @Autowired
    private bookservice bs;
    @GetMapping("/getbookdetail/{id}")
    public String detail(@PathVariable(name="id") long id, Model model){
        Optional<book> bk=bs.findone(id);
        model.addAttribute("books",bk);
        return "books";
    }
    @GetMapping("/bookdetailtest")
    public String newdetail(){
        return "book";
    }


}
