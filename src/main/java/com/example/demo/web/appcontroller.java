package com.example.demo.web;

import com.example.demo.domain.book;
import com.example.demo.service.bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class appcontroller {
    @Autowired
    private bookservice bs;

    @GetMapping("/getinformation")
    public List<book> getall(){
        return bs.findall();
    }
    @PostMapping("/savenew")
    public book post(@RequestParam String name,
                     @RequestParam String author,
                     @RequestParam String description,
                     @RequestParam int status){
        book book2 =new book();
        book2.setName(name);
        book2.setAuthor(author);
        book2.setDescriptiion(description);
        book2.setStatus(status);
        return bs.save(book2);
    }
    @GetMapping("/getone/{id}")
    public Optional<book> findone(@PathVariable long id){
        return bs.findone(id);
    }


    @PutMapping("/updateone")
    public book updateone(
                     @RequestParam long id,
                     @RequestParam String name,
                     @RequestParam String author,
                     @RequestParam String description,
                     @RequestParam int status){
        book book1 =new book();
        book1.setId(id);
        book1.setName(name);
        book1.setAuthor(author);
        book1.setDescriptiion(description);
        book1.setStatus(status);
        return bs.save(book1);
    }
    @PutMapping("/newupdateone")
    public book newupdateone(
            @RequestParam String name,
            @RequestParam String author,
            @RequestParam String description,
            @RequestParam int status){
        book book1 =new book();
        book1.setName(name);
        book1.setAuthor(author);
        book1.setDescriptiion(description);
        book1.setStatus(status);
        return bs.save(book1);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteone(@PathVariable long id){
        bs.delete(id);
    }

    @PostMapping("/findauthor")
    public List<book>findauthor(@RequestParam String author){
        return bs.findbyauthor(author);
    }

    @PostMapping("/findbyauthorandstatus")
    public List<book>findauthorandstatus(@RequestParam String author,@RequestParam int status){
        return bs.findbyauthorandstatus(author,status);
    }

    @PostMapping("/updatestatusfromid")
    public int updatejpql(@RequestParam int status,@RequestParam long id){
        return bs.updatebyjpql(status,id);
    }


}
