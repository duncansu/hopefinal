package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface bookrepository extends JpaRepository<book,Long> {
@Query("select b from book b where b.author = ?1")
List<book>findByAuthor(String author);
//根據方法規則來進行查詢
@Query("select b from book b where b.author = ?1 and b.status = ?2")
List<book>findByAuthorAndStatus(String author, int status);
@Modifying
@Query("update book b set b.status= ?1 where id= ?2")
int  updateurjpql(int status,long id);

}
