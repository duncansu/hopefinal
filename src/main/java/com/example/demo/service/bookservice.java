package com.example.demo.service;

import com.example.demo.domain.book;
import com.example.demo.domain.bookrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class bookservice {
    @Autowired
    private bookrepository br;
//    查詢所有的書單列表
    public List<book>findall(){
        return br.findAll();
    }
//    新增一個書單
    public book save(book bk){
        return br.save(bk);

    }
    public Optional<book> findone(long id){
        return br.findById(id);
    }

    public void delete(long id){
        br.deleteById(id);
    }
    public List<book> findbyauthor(String author){
        return br.findByAuthor(author);
    }
    public List<book> findbyauthorandstatus(String author,int status){
        return br.findByAuthorAndStatus(author,status);
    }
    @Transactional
    public int updatebyjpql(int status,long id){
        return br.updateurjpql(status,id);
    }
}
